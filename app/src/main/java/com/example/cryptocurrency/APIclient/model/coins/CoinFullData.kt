package com.example.cryptocurrency.APIclient.model.coins

import androidx.room.Entity
import com.example.cryptocurrency.APIclient.internal.NullValueOmittingListSerializer
import com.example.cryptocurrency.APIclient.model.coins.data.*
import com.example.cryptocurrency.APIclient.model.shared.Image
import com.example.cryptocurrency.APIclient.model.shared.Ticker
import com.example.cryptocurrency.APIclient.model.status.Update
import com.google.gson.annotations.SerializedName

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Entity
data class CoinFullData(
    val id: String,
    @SerializedName("market_data")
    val marketData: MarketData? = null,
    val description: Map<String, String>,
    @SerializedName("coingecko_rank")
    val coingeckoRank: Long = 0,

    /*@SerialName("asset_platform_id")
    val assetPlatformId: String?,
    val symbol: String,
     val name: String,
    val platforms: Map<String, String> = emptyMap(),
    @SerialName("block_time_in_minutes")
    val blockTimeInMinutes: Long = 0,
    @SerialName("hashing_algorithm")
    val hashingAlgorithm: String? = null,
    @Serializable(NullValueOmittingListSerializer::class)
    val categories: List<String>,
    @SerialName("public_notice")
    val publicNotice: String? = null,
    @SerialName("additional_notices")
    val additionalNotices: List<String> = emptyList(),
    val localization: Map<String, String>,

    val links: Links,
    val image: Image,
    @SerialName("country_origin")
    val countryOrigin: String? = null,
    @SerialName("genesis_date")
    val genesisDate: String? = null,
    @SerialName("sentiment_votes_up_percentage")
    val sentimentVotesUpPercentage: Float = 50f,
    @SerialName("sentiment_votes_down_percentage")
    val sentimentVotesDownPercentage: Float = 50f,
    @SerialName("market_cap_rank")
    val marketCapRank: Long = 0,

    @SerialName("coingecko_score")
    val coingeckoScore: Double = 0.0,
    @SerialName("developer_score")
    val developerScore: Double = 0.0,
    @SerialName("community_score")
    val communityScore: Double = 0.0,
    @SerialName("liquidity_score")
    val liquidityScore: Double = 0.0,
    @SerialName("public_interest_score")
    val publicInterestScore: Double = 0.0,
    @SerialName("community_data")
    val communityData: CommunityData? = null,
    @SerialName("developer_data")
    val developerData: DeveloperData? = null,
    @SerialName("public_interest_stats")
    val publicInterestStats: PublicInterestStats? = null,
    @SerialName("status_updates")
    val statusUpdates: List<Update>? = null,
    @SerialName("last_updated")
    val lastUpdated: String? = null,
    val tickers: List<Ticker>? = null,
    @SerialName("contract_address")
    val contractAddress: String? = null,
    @SerialName("ico_data")
    val icoData: IcoData? = null*/
)