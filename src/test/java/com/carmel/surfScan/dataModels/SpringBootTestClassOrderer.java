package com.carmel.surfScan.dataModels;

import org.junit.jupiter.api.ClassDescriptor;
import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.ClassOrdererContext;
import org.springframework.kafka.test.context.EmbeddedKafka;

import java.util.Comparator;

public class SpringBootTestClassOrderer implements ClassOrderer {
    @Override
    public void orderClasses(ClassOrdererContext classOrdererContext) {
        classOrdererContext.getClassDescriptors().sort(Comparator.comparingInt(SpringBootTestClassOrderer::getOrder));
    }

    private static int getOrder(ClassDescriptor classDescriptor) {
        if (classDescriptor.findAnnotation(EmbeddedKafka.class).isPresent()) {
            return 1;
        } else {
            return 2;
        }
    }
}