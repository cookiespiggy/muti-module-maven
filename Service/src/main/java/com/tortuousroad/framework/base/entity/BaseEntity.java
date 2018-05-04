package com.tortuousroad.framework.base.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class BaseEntity implements Serializable {

    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String routerCall;

    /**
     * 获取给定实体(BaseEntity的子集)集合的ID集合
     *
     * @param entities 实体集合
     * @param <T>      实体类型(BaseEntity的子集)
     * @return ID集合
     */
    public static <T extends BaseEntity> List<Long> idList(List<T> entities) {
        return entities.stream().map(entity -> entity.getId()).collect(Collectors.toList());
    }

    /**
     * 将给定的实体集合转换成为实体ID为Key,实体为Value的Map
     *
     * @param entities 实体集合
     * @param <T>      实体类型
     * @return ID-实体 Map
     */
    public static <T extends BaseEntity> Map<Long, T> idEntityMap(List<T> entities) {
        Map<Long, T> idMap = entities.stream().collect(Collectors.toMap(T::getId, entity -> entity));
        return idMap;
    }
}
