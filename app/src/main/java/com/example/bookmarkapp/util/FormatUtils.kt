package com.example.bookmarkapp.util

import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

object FormatUtils {
    var dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale("ko", "KR"))

    var priceFormat = DecimalFormat("#,##0")
}