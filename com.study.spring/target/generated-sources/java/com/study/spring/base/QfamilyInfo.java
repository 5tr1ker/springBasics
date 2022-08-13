package com.study.spring.base;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QfamilyInfo is a Querydsl query type for familyInfo
 */
@Generated("com.mysema.query.codegen.EmbeddableSerializer")
public class QfamilyInfo extends BeanPath<familyInfo> {

    private static final long serialVersionUID = -2083973472L;

    public static final QfamilyInfo familyInfo = new QfamilyInfo("familyInfo");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final StringPath name = createString("name");

    public final StringPath sex = createString("sex");

    public QfamilyInfo(String variable) {
        super(familyInfo.class, forVariable(variable));
    }

    public QfamilyInfo(Path<? extends familyInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QfamilyInfo(PathMetadata<?> metadata) {
        super(familyInfo.class, metadata);
    }

}

