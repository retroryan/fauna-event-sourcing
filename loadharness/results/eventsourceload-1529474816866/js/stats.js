var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "4800",
        "ok": "4800",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "5",
        "ok": "5",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "78",
        "ok": "78",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "27",
        "ok": "27",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "16",
        "ok": "16",
        "ko": "-"
    },
    "percentiles1": {
        "total": "20",
        "ok": "20",
        "ko": "-"
    },
    "percentiles2": {
        "total": "29",
        "ok": "29",
        "ko": "-"
    },
    "percentiles3": {
        "total": "64",
        "ok": "64",
        "ko": "-"
    },
    "percentiles4": {
        "total": "71",
        "ok": "71",
        "ko": "-"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 4800,
        "percentage": 100
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group4": {
        "name": "failed",
        "count": 0,
        "percentage": 0
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "39.669",
        "ok": "39.669",
        "ko": "-"
    }
},
contents: {
"req_add-34ec7": {
        type: "REQUEST",
        name: "add",
path: "add",
pathFormatted: "req_add-34ec7",
stats: {
    "name": "add",
    "numberOfRequests": {
        "total": "4800",
        "ok": "4800",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "5",
        "ok": "5",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "78",
        "ok": "78",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "27",
        "ok": "27",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "16",
        "ok": "16",
        "ko": "-"
    },
    "percentiles1": {
        "total": "20",
        "ok": "20",
        "ko": "-"
    },
    "percentiles2": {
        "total": "29",
        "ok": "29",
        "ko": "-"
    },
    "percentiles3": {
        "total": "64",
        "ok": "64",
        "ko": "-"
    },
    "percentiles4": {
        "total": "71",
        "ok": "71",
        "ko": "-"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 4800,
        "percentage": 100
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group4": {
        "name": "failed",
        "count": 0,
        "percentage": 0
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "39.669",
        "ok": "39.669",
        "ko": "-"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
