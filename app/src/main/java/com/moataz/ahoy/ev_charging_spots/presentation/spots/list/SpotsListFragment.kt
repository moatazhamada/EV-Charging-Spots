package com.moataz.ahoy.ev_charging_spots.presentation.spots.list

import android.Manifest
import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipDescription
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.os.Looper
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.location.*
import com.moataz.ahoy.ev_charging_spots.R
import com.moataz.ahoy.ev_charging_spots.databinding.FragmentSpotsListBinding
import com.moataz.ahoy.ev_charging_spots.databinding.ItemChargingPointContentBinding
import com.moataz.ahoy.ev_charging_spots.presentation.spots.details.SpotsDetailsFragment
import com.moataz.ahoy.ev_charging_spots.presentation.spots.placeholder.PlaceholderContent

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class SpotsListFragment : Fragment() {

    private var _binding: FragmentSpotsListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val PERMISSION_ID = 42
    private lateinit var mFusedLocationClient: FusedLocationProviderClient

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        _binding = FragmentSpotsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())

        getLastLocation()

        val recyclerView: RecyclerView = binding.itemList

        // Leaving this not using view binding as it relies on if the view is visible the current
        // layout configuration (layout, layout-sw600dp)
        val itemDetailFragmentContainer: View? = view.findViewById(R.id.item_detail_nav_container)

        setupRecyclerView(recyclerView, itemDetailFragmentContainer)
    }

    private fun setupRecyclerView(
        recyclerView: RecyclerView,
        itemDetailFragmentContainer: View?
    ) {

        recyclerView.adapter = SimpleItemRecyclerViewAdapter(
            PlaceholderContent.ITEMS, itemDetailFragmentContainer
        )
    }

    class SimpleItemRecyclerViewAdapter(
        private val values: List<PlaceholderContent.PlaceholderItem>,
        private val itemDetailFragmentContainer: View?
    ) :
        RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

            val binding =
                ItemChargingPointContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ViewHolder(binding)

        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = values[position]
//            holder.idView.text = item.id
//            holder.contentView.text = item.content

            with(holder.itemView) {
                tag = item
                setOnClickListener { itemView ->
                    val placeholderItem = itemView.tag as PlaceholderContent.PlaceholderItem
                    val bundle = Bundle()
                    bundle.putString(
                        SpotsDetailsFragment.ARG_ITEM_ID,
                        placeholderItem.id
                    )
                    if (itemDetailFragmentContainer != null) {
                        itemDetailFragmentContainer.findNavController()
                            .navigate(R.id.SpotsDetailsFragment, bundle)
                    } else {
                        itemView.findNavController().navigate(R.id.SpotsDetailsFragment, bundle)
                    }
                }
                /**
                 * Context click listener to handle Right click events
                 * from mice and trackpad input to provide a more native
                 * experience on larger screen devices
                 */
                setOnContextClickListener { v ->
                    val placeholderItem = v.tag as PlaceholderContent.PlaceholderItem
                    Toast.makeText(
                        v.context,
                        "Context click of item " + placeholderItem.id,
                        Toast.LENGTH_LONG
                    ).show()
                    true
                }

                setOnLongClickListener { v ->
                    // Setting the item id as the clip data so that the drop target is able to
                    // identify the id of the content
                    val clipItem = ClipData.Item(item.id)
                    val dragData = ClipData(
                        v.tag as? CharSequence,
                        arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                        clipItem
                    )

                    v.startDragAndDrop(
                        dragData,
                        View.DragShadowBuilder(v),
                        null,
                        0
                    )
                }
            }
        }

        override fun getItemCount() = values.size

        inner class ViewHolder(binding: ItemChargingPointContentBinding) :
            RecyclerView.ViewHolder(binding.root) {
//            val idView: TextView = binding.idText
//            val contentView: TextView = binding.content
        }

    }


    @SuppressLint("MissingPermission")
    private fun getLastLocation() {
        if (checkPermissions()) {
            if (isLocationEnabled()) {
                onLocationEnabled()
            } else {
                Toast.makeText(requireContext(), "Turn on location", Toast.LENGTH_LONG).show()
                val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                startActivity(intent)
            }
        } else {
            val permissionLauncher = registerForActivityResult(
                ActivityResultContracts.RequestPermission()
            ) { isGranted ->
                if (isGranted) {
                    onLocationEnabled()
                } else {
                    requestPermissions()
                }
            }
            permissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }

    @SuppressLint("MissingPermission")
    private fun onLocationEnabled() {
        mFusedLocationClient.lastLocation.addOnCompleteListener(requireActivity()) { task ->
            val location: Location? = task.result
            if (location == null) {
                requestNewLocationData()
            } else {
                //                        findViewById<TextView>(R.id.latTextView).text = location.latitude.toString()
                //                        findViewById<TextView>(R.id.lonTextView).text = location.longitude.toString()
            }
        }
    }

    @SuppressLint("MissingPermission")
    private fun requestNewLocationData() {
        val mLocationRequest = LocationRequest()
        mLocationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        mLocationRequest.interval = 0
        mLocationRequest.fastestInterval = 0
        mLocationRequest.numUpdates = 1

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())
        mFusedLocationClient.requestLocationUpdates(
            mLocationRequest, mLocationCallback,
            Looper.myLooper()
        )
    }

    private val mLocationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult) {
            var mLastLocation: Location? = locationResult.lastLocation
//            findViewById<TextView>(R.id.latTextView).text = mLastLocation.latitude.toString()
//            findViewById<TextView>(R.id.lonTextView).text = mLastLocation.longitude.toString()
        }
    }

    private fun isLocationEnabled(): Boolean {
        val locationManager: LocationManager =
            requireActivity().getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(
            LocationManager.NETWORK_PROVIDER
        )
    }

    private fun checkPermissions(): Boolean {
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            return true
        }
        return false
    }

    private fun requestPermissions() {
        ActivityCompat.requestPermissions(
            requireActivity(),
            arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION),
            PERMISSION_ID
        )
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray,
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_ID) {
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                getLastLocation()
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}