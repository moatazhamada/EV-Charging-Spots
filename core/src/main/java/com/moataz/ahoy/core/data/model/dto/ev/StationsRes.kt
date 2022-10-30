package com.moataz.ahoy.core.data.model.dto.ev


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class StationData(
    @SerializedName("access_code")
    val accessCode: String, // private
    @SerializedName("access_days_time")
    val accessDaysTime: String, // Fleet use only
    @SerializedName("access_days_time_fr")
    val accessDaysTimeFr: String,
    @SerializedName("access_detail_code")
    val accessDetailCode: String,
    @SerializedName("bd_blends")
    val bdBlends: String,
    @SerializedName("bd_blends_fr")
    val bdBlendsFr: String,
    @SerializedName("cards_accepted")
    val cardsAccepted: String,
    @SerializedName("city")
    val city: String, // Sun Valley
    @SerializedName("cng_dispenser_num")
    val cngDispenserNum: String,
    @SerializedName("cng_fill_type_code")
    val cngFillTypeCode: String,
    @SerializedName("cng_psi")
    val cngPsi: String,
    @SerializedName("cng_renewable_source")
    val cngRenewableSource: String,
    @SerializedName("cng_total_compression")
    val cngTotalCompression: String,
    @SerializedName("cng_total_storage")
    val cngTotalStorage: String,
    @SerializedName("cng_vehicle_class")
    val cngVehicleClass: String,
    @SerializedName("date_last_confirmed")
    val dateLastConfirmed: String, // 2021-07-14
    @SerializedName("e85_blender_pump")
    val e85BlenderPump: String,
    @SerializedName("e85_other_ethanol_blends")
    val e85OtherEthanolBlends: String,
    @SerializedName("ev_connector_types")
    val evConnectorTypes: String, // CHADEMO J1772 J1772COMBO
    @SerializedName("ev_dc_fast_num")
    val evDcFastNum: String, // 3
    @SerializedName("ev_level1_evse_num")
    val evLevel1EvseNum: String,
    @SerializedName("ev_level2_evse_num")
    val evLevel2EvseNum: String, // 39
    @SerializedName("ev_network")
    val evNetwork: String, // Non-Networked
    @SerializedName("ev_network_web")
    val evNetworkWeb: String,
    @SerializedName("ev_other_evse")
    val evOtherEvse: String,
    @SerializedName("ev_pricing")
    val evPricing: String,
    @SerializedName("ev_pricing_fr")
    val evPricingFr: String,
    @SerializedName("ev_renewable_source")
    val evRenewableSource: String,
    @SerializedName("expected_date")
    val expectedDate: String,
    @SerializedName("facility_type")
    val facilityType: String, // UTILITY
    @SerializedName("federal_agency_code")
    val federalAgencyCode: String,
    @SerializedName("federal_agency_id")
    val federalAgencyId: String,
    @SerializedName("federal_agency_name")
    val federalAgencyName: String,
    @SerializedName("fuel_type_code")
    val fuelTypeCode: String, // ELEC
    @SerializedName("geocode_status")
    val geocodeStatus: String, // GPS
    @SerializedName("groups_with_access_code")
    val groupsWithAccessCode: String, // Private
    @SerializedName("groups_with_access_code_fr")
    val groupsWithAccessCodeFr: String, // Privé
    @SerializedName("hy_is_retail")
    val hyIsRetail: String,
    @SerializedName("hy_pressures")
    val hyPressures: String,
    @SerializedName("hy_standards")
    val hyStandards: String,
    @SerializedName("hy_status_link")
    val hyStatusLink: String,
    @SerializedName("intersection_directions")
    val intersectionDirections: String,
    @SerializedName("intersection_directions_fr")
    val intersectionDirectionsFr: String,
    @SerializedName("latitude")
    val latitude: String, // 34.2483191527193
    @SerializedName("lng_renewable_source")
    val lngRenewableSource: String,
    @SerializedName("lng_vehicle_class")
    val lngVehicleClass: String,
    @SerializedName("longitude")
    val longitude: String, // -118.3879713743439
    @SerializedName("lpg_nozzle_types")
    val lpgNozzleTypes: String,
    @SerializedName("lpg_primary")
    val lpgPrimary: String,
    @SerializedName("ng_fill_type_code")
    val ngFillTypeCode: String,
    @SerializedName("ng_psi")
    val ngPsi: String,
    @SerializedName("ng_vehicle_class")
    val ngVehicleClass: String,
    @SerializedName("open_date")
    val openDate: String, // 1999-10-15
    @SerializedName("owner_type_code")
    val ownerTypeCode: String, // LG
    @SerializedName("plus4")
    val plus4: String,
    @SerializedName("postcode")
    val postcode: String, // 91352
    @SerializedName("restricted_access")
    val restrictedAccess: String,
    @SerializedName("state")
    val state: String, // CA
    @SerializedName("station_name")
    val stationName: String, // LADWP - Truesdale Center
    @SerializedName("station_phone")
    val stationPhone: String,
    @SerializedName("status_code")
    val statusCode: String, // E
    @SerializedName("street_address")
    val streetAddress: String, // 11797 Truesdale St
    @SerializedName("updated_at")
    val updatedAt: String, // 2022-07-18 11:36:50 UTC
)
