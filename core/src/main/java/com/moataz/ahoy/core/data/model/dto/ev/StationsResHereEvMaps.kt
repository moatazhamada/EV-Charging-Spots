package com.moataz.ahoy.core.data.model.dto.ev


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class StationsResHereEvMaps(
    @SerializedName("count")
    val count: Int, // 50
    @SerializedName("evStations")
    val evStations: EvStations,
    @SerializedName("hasMore")
    val hasMore: Boolean // true
) {
    @Keep
    data class EvStations(
        @SerializedName("evStation")
        val evStation: List<EvStation>
    ) {
        @Keep
        data class EvStation(
            @SerializedName("address")
            val address: Address,
            @SerializedName("connectors")
            val connectors: Connectors,
            @SerializedName("contacts")
            val contacts: Contacts,
            @SerializedName("distance")
            val distance: Int, // 421
            @SerializedName("evStationDetails")
            val evStationDetails: EvStationDetails,
            @SerializedName("id")
            val id: String, // 276u33db-b2c840878cfc409fa5a0aef858419037
            @SerializedName("lastUpdateTimestamp")
            val lastUpdateTimestamp: String, // 2015-08-28T04:39:27.737Z
            @SerializedName("name")
            val name: String, // RWE Effizienz GmbH
            @SerializedName("poolId")
            val poolId: String, // 276u33db845jn-aGVyZS1ldjplY29tb3ZlbWVudDo4OTU5MDU0ODI
            @SerializedName("position")
            val position: Position,
            @SerializedName("timeZone")
            val timeZone: String, // Europe/Berlin
            @SerializedName("totalNumberOfConnectors")
            val totalNumberOfConnectors: Int // 2
        ) {
            @Keep
            data class Address(
                @SerializedName("city")
                val city: String, // Berlin
                @SerializedName("country")
                val country: String, // DEU
                @SerializedName("postalCode")
                val postalCode: String, // 10117
                @SerializedName("region")
                val region: String, // Berlin
                @SerializedName("street")
                val street: String, // Luisenstraße
                @SerializedName("streetNumber")
                val streetNumber: String // 31
            )

            @Keep
            data class Connectors(
                @SerializedName("connector")
                val connector: List<Connector>
            ) {
                @Keep
                data class Connector(
                    @SerializedName("chargeCapacity")
                    val chargeCapacity: String, // 380-480VAC, 3-phase at max. 32 A
                    @SerializedName("chargingPoint")
                    val chargingPoint: ChargingPoint,
                    @SerializedName("connectorDetails")
                    val connectorDetails: ConnectorDetails,
                    @SerializedName("connectorType")
                    val connectorType: ConnectorType,
                    @SerializedName("customerChargeLevel")
                    val customerChargeLevel: String, // 3
                    @SerializedName("customerConnectorName")
                    val customerConnectorName: String, // AC EV connector (Mennekes - type 2)
                    @SerializedName("fixedCable")
                    val fixedCable: Boolean, // false
                    @SerializedName("maxPowerLevel")
                    val maxPowerLevel: Double, // 22.08
                    @SerializedName("supplierName")
                    val supplierName: String // RWE eRoaming
                ) {
                    @Keep
                    data class ChargingPoint(
                        @SerializedName("ampsRange")
                        val ampsRange: String, // 32A
                        @SerializedName("chargeMode")
                        val chargeMode: String, // 3
                        @SerializedName("numberOfConnectors")
                        val numberOfConnectors: Int, // 2
                        @SerializedName("phases")
                        val phases: Int, // 3
                        @SerializedName("voltsRange")
                        val voltsRange: String // 380-480V AC
                    )

                    @Keep
                    data class ConnectorDetails(
                        @SerializedName("manufacturer")
                        val manufacturer: String, // RWE
                        @SerializedName("open24x7")
                        val open24x7: Boolean, // true
                        @SerializedName("openingHours")
                        val openingHours: OpeningHours,
                        @SerializedName("pay")
                        val pay: Boolean, // true
                        @SerializedName("privateAccess")
                        val privateAccess: Boolean // false
                    ) {
                        @Keep
                        data class OpeningHours(
                            @SerializedName("annualOpenings")
                            val annualOpenings: List<Any>,
                            @SerializedName("regularOpeningHours")
                            val regularOpeningHours: List<RegularOpeningHour>
                        ) {
                            @Keep
                            data class RegularOpeningHour(
                                @SerializedName("daymask")
                                val daymask: Int, // 127
                                @SerializedName("period")
                                val period: List<Period>
                            ) {
                                @Keep
                                data class Period(
                                    @SerializedName("from")
                                    val from: String, // 00:00:00
                                    @SerializedName("to")
                                    val to: String // 24:00:00
                                )
                            }
                        }
                    }

                    @Keep
                    data class ConnectorType(
                        @SerializedName("id")
                        val id: String, // 31
                        @SerializedName("name")
                        val name: String // IEC 62196-2 type 2 (Mennekes)
                    )
                }
            }

            @Keep
            data class Contacts(
                @SerializedName("phone")
                val phone: List<Phone>
            ) {
                @Keep
                data class Phone(
                    @SerializedName("label")
                    val label: String, // PHONE
                    @SerializedName("value")
                    val value: String // +498002255793
                )
            }

            @Keep
            data class EvStationDetails(
                @SerializedName("accessibilityType")
                val accessibilityType: String, // RESTRICTED
                @SerializedName("notes")
                val notes: String, // Ladestation RWE Effizienz GmbH
                @SerializedName("paymentMethods")
                val paymentMethods: PaymentMethods,
                @SerializedName("privateAccess")
                val privateAccess: Boolean, // false
                @SerializedName("restrictedAccess")
                val restrictedAccess: Boolean // true
            ) {
                @Keep
                data class PaymentMethods(
                    @SerializedName("note")
                    val note: String, // Mobile Payment Option Available
                    @SerializedName("subscription")
                    val subscription: Subscription
                ) {
                    @Keep
                    data class Subscription(
                        @SerializedName("accept")
                        val accept: Boolean, // true
                        @SerializedName("provider")
                        val provider: String // RWE eRoaming
                    )
                }
            }

            @Keep
            data class Position(
                @SerializedName("latitude")
                val latitude: Double, // 52.5199013
                @SerializedName("longitude")
                val longitude: Double // 13.3800898
            )
        }
    }
}