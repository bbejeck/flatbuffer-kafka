package io.confluent.developer.serde;

import io.confluent.developer.flatbuffer.Stock;
import org.apache.kafka.common.serialization.Serializer;

import java.nio.ByteBuffer;

/**
 * A Serializer that does no actual serialization.
 * Instead this Serializer instance returns the underlying
 * byte array contained in the ByteBuffer instance.
 */
public class FlatbufferSerializer implements Serializer<Stock> {


    @Override
    public byte[] serialize(String s, Stock stock) {
        if (stock == null) {
            return null;
        }
        ByteBuffer byteBuffer = stock.getByteBuffer();
        byte[] bytes = new byte[byteBuffer.remaining()];
        byteBuffer.get(bytes);
        return bytes;
    }
}