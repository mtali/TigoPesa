package com.mtali.tigopesa.core.utils

import androidx.tracing.Trace

inline fun <T> trace(label: String, crossinline block: () -> T): T {
    try {
        Trace.beginSection(label)
        return block()
    } finally {
        Trace.endSection()
    }
}