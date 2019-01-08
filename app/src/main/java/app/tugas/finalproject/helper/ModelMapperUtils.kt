package app.tugas.finalproject.helper

import org.modelmapper.ModelMapper

object ModelMapperUtils {
    private var instance = ModelMapper()

    fun configuration(): ModelMapper {
        instance.configuration.isSkipNullEnabled = true
        instance.configuration.isAmbiguityIgnored = true
        return ModelMapperUtils.instance
    }

}