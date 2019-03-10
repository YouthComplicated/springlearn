package com.lanmo.condition;


import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {


    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        //importingClassMetadata.get
        return new String[]{"com.lanmo.bean.Customer",
                "com.lanmo.bean.Person"};
    }
}
