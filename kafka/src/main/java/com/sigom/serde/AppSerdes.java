package com.sigom.serde;

import com.sigom.types.AdClick;
import com.sigom.types.AdImpression;
import com.sigom.types.CampaingPerformance;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;

import java.util.HashMap;
import java.util.Map;

public class AppSerdes extends Serdes {

    static final class AdImpressionSerde extends WrapperSerde<AdImpression> {
        AdImpressionSerde() {
            super(new JsonSerializer<>(), new JsonDeserializer<>());
        }
    }

    public static Serde<AdImpression> AdImpression() {
        AdImpressionSerde serde = new AdImpressionSerde();

        Map<String, Object> serdeConfigs = new HashMap<>();
        serdeConfigs.put(JsonDeserializer.VALUE_CLASS_NAME_CONFIG, AdImpression.class);
        serde.configure(serdeConfigs, false);

        return serde;
    }

    static final class AdClickSerde extends WrapperSerde<AdClick> {
        AdClickSerde() {
            super(new JsonSerializer<>(), new JsonDeserializer<>());
        }
    }

    public static Serde<AdClick> AdClick() {
        AdClickSerde serde = new AdClickSerde();

        Map<String, Object> serdeConfigs = new HashMap<>();
        serdeConfigs.put(JsonDeserializer.VALUE_CLASS_NAME_CONFIG, AdClick.class);
        serde.configure(serdeConfigs, false);
        return serde;
    }

    static final class CampaingPerfomanceSerde extends WrapperSerde<CampaingPerformance> {
        CampaingPerfomanceSerde() {
            super(new JsonSerializer<>(), new JsonDeserializer<>());
        }
    }

    public static Serde<CampaingPerformance> CampaingPerfomance() {
        CampaingPerfomanceSerde serde = new CampaingPerfomanceSerde();

        Map<String, Object> serdeConfigs = new HashMap<>();
        serdeConfigs.put(JsonDeserializer.VALUE_CLASS_NAME_CONFIG, CampaingPerformance.class);
        serde.configure(serdeConfigs, false);
        return serde;
    }
}
