package com.reactiveclient.client;

import com.reactiveclient.HttpErrorReader;
import com.reactiveclient.client.codec.ExtendedClientCodecConfigurer;
import org.springframework.web.reactive.function.client.ExchangeStrategies;

import java.util.function.Supplier;
import java.util.stream.Stream;

interface ExtendedExchangeStrategies extends ExchangeStrategies {

    Supplier<Stream<HttpErrorReader>> exceptionReader();

    static ExtendedExchangeStrategies of(ExtendedClientCodecConfigurer configurer) {
        return new DefaultExtendedExchangeStrategies(
                configurer.getWriters(),
                configurer.getReaders(),
                configurer.getErrorReaders());
    }
}
