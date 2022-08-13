package com.study.spring.base;

import static com.mysema.query.types.PathMetadataFactory.forVariable;

import javax.annotation.Generated;

import com.mysema.query.types.Path;
import com.mysema.query.types.PathMetadata;
import com.mysema.query.types.path.EntityPathBase;
import com.mysema.query.types.path.ListPath;
import com.mysema.query.types.path.NumberPath;
import com.mysema.query.types.path.PathInits;
import com.mysema.query.types.path.StringPath;


/**
 * QMemberVO is a Querydsl query type for MemberVO
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QMemberVO extends EntityPathBase<MemberVO> {

    private static final long serialVersionUID = 194327265L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMemberVO memberVO = new QMemberVO("memberVO");


    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final QAgencyVO agency;

    //inherited

    public final ListPath<familyInfo, QfamilyInfo> familyInfo = this.<familyInfo, QfamilyInfo>createList("familyInfo", familyInfo.class, QfamilyInfo.class, PathInits.DIRECT2);

    //inherited

    public final NumberPath<Integer> number = createNumber("number", Integer.class);

    public final ListPath<OrderData, QOrderData> orders = this.<OrderData, QOrderData>createList("orders", OrderData.class, QOrderData.class, PathInits.DIRECT2);

    //inherited

    public final StringPath userId = createString("userId");

    public final QuserInfo userInfo;

    public final StringPath userName = createString("userName");

    public QMemberVO(String variable) {
        this(MemberVO.class, forVariable(variable), INITS);
    }

    public QMemberVO(Path<? extends MemberVO> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QMemberVO(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QMemberVO(PathMetadata<?> metadata, PathInits inits) {
        this(MemberVO.class, metadata, inits);
    }

    public QMemberVO(Class<? extends MemberVO> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.agency = inits.isInitialized("agency") ? new QAgencyVO(forProperty("agency")) : null;
        this.userInfo = inits.isInitialized("userInfo") ? new QuserInfo(forProperty("userInfo")) : null;
    }

}

