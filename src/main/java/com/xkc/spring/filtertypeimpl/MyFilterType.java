package com.xkc.spring.filtertypeimpl;

import com.xkc.spring.custom.MyComponent;
import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

public class MyFilterType implements TypeFilter {

    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) {

        // 获取扫描类的注解元数据
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();

        // 获取扫描类的Class元数据
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        System.out.println(classMetadata.getClassName());

        // 获取类资源信息
        Resource resource = metadataReader.getResource();

        if (annotationMetadata.hasAnnotation(MyComponent.class.getName())) {
            return true;
        }
        return false;
    }

}
