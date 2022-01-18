package com.example.it.service.mapper.config;

import com.example.it.dao.data.form.SearchForm;
import com.example.it.dao.models.Form;
import com.example.it.service.mapper.form.FormToFormDto;
import ma.glasnost.orika.MapperFactory;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;
import org.springframework.stereotype.Component;

@Component
public class OrikaMapperConfig implements OrikaMapperFactoryConfigurer {

    @Override
    public void configure(MapperFactory orikaMapperFactory) {

        orikaMapperFactory.classMap(Form.class, SearchForm.class)
                .customize(new FormToFormDto()).
                register();
    }
}
