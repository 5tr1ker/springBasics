package com.study.spring.base;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QuserInfo is a Querydsl query type for userInfo
 */
@Generated("com.mysema.query.codegen.EmbeddableSerializer")
public class QuserInfo extends BeanPath<userInfo> {

    private static final long serialVersionUID = 512319239L;

    public static final QuserInfo userInfo = new QuserInfo("userInfo");

    public final StringPath address = createString("address");

    public final NumberPath<Integer> family = createNumber("family", Integer.class);

    public final NumberPath<Integer> familycount = createNumber("familycount", Integer.class);

    public final StringPath job = createString("job");

    public QuserInfo(String variable) {
        super(userInfo.class, forVariable(variable));
    }

    public QuserInfo(Path<? extends userInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QuserInfo(PathMetadata<?> metadata) {
        super(userInfo.class, metadata);
    }

}

