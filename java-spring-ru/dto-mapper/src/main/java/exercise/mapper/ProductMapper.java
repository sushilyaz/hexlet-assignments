package exercise.mapper;

import exercise.dto.*;
import exercise.model.*;
import org.mapstruct.*;

// BEGIN
@Mapper(
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class ProductMapper {
    @Mapping(target = "name", source = "title")
    @Mapping(target = "cost", source = "price")
    @Mapping(target = "barcode", source = "vendorCode")
    public abstract Product map(ProductCreateDTO dto);

    @Mapping(target = "title", source = "name")
    @Mapping(target = "price", source = "cost")
    @Mapping(target = "vendorCode", source = "barcode")
    public abstract ProductDTO map(Product product);

    @Mapping(target = "cost", source = "price")
    public abstract void update(ProductUpdateDTO dto, @MappingTarget Product product);
}
// END
