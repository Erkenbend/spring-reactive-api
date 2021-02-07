package com.example.spring_reactive.server.mapping;

import com.example.spring_reactive.api.spring_server.model.Thing;
import com.example.spring_reactive.server.db.model.ThingDAO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ThingMapper {
    ThingMapper INSTANCE = Mappers.getMapper(ThingMapper.class);

    ThingDAO thingApiToDb(Thing thing);
    Thing thingDbToApi(ThingDAO thingDAO);
}
