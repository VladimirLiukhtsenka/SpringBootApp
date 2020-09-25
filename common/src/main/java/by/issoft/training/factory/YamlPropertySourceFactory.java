package by.issoft.training.factory;

import by.issoft.training.exception.YamlPropertySourceFactoryException;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;
import org.springframework.lang.Nullable;

import java.util.Objects;
import java.util.Properties;

public class YamlPropertySourceFactory implements PropertySourceFactory {

    @Override
    public PropertySource<?> createPropertySource(@Nullable String name, @Nullable EncodedResource resource) {
        if (resource == null) {
            throw new YamlPropertySourceFactoryException("Unable to load properties");
        }

        Properties properties = loadYamlIntoProperties(resource);

        String sourceName;
        sourceName = name != null ? name : resource.getResource().getFilename();

        return new PropertiesPropertySource(Objects.requireNonNull(sourceName), properties);
    }

    private Properties loadYamlIntoProperties(EncodedResource resource) {
        try {
            YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
            factory.setResources(resource.getResource());
            factory.afterPropertiesSet();

            return factory.getObject();
        } catch (IllegalStateException e) {
            throw new YamlPropertySourceFactoryException("Unable to load properties", e);
        }
    }
}