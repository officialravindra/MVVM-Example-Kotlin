package com.example.mvvmkotlinexample.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("jsonschema2pojo")
class GetPlansDetails {
    @SerializedName("plan_id")
    @Expose
    var planId: String? = null

    @SerializedName("plan_name")
    @Expose
    var planName: String? = null

    @SerializedName("admission_fee")
    @Expose
    var admissionFee: String? = null

    @SerializedName("plan_amount")
    @Expose
    var planAmount: String? = null

    @SerializedName("tenure")
    @Expose
    var tenure: String? = null

    @SerializedName("start_month")
    @Expose
    var startMonth: String? = null

    @SerializedName("agent_commission")
    @Expose
    var agentCommission: String? = null

    @SerializedName("emi")
    @Expose
    var emi: String? = null

    @SerializedName("total_subscription")
    @Expose
    var totalSubscription: String? = null

    @SerializedName("months_completed")
    @Expose
    var monthsCompleted: String? = null

    @SerializedName("total_months")
    @Expose
    var totalMonths: String? = null

    @SerializedName("groups_counts")
    @Expose
    var groupsCounts: String? = null

    @SerializedName("end_date_for subscription")
    @Expose
    var endDateForSubscription: Any? = null

    @SerializedName("status")
    @Expose
    var status: String? = null

    @SerializedName("added_date")
    @Expose
    var addedDate: String? = null

    @SerializedName("update_date")
    @Expose
    var updateDate: String? = null

}