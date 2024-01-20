package com.example.hilttutorial.hilt

import com.example.hilttutorial.network.Interceptor
import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation  class CallInterceptorQualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation  class ResponseInterceptorQualifier
