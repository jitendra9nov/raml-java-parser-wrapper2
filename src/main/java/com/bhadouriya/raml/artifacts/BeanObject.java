package com.bhadouriya.raml.artifacts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang.WordUtils;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BeanObject {
    private final List<String> dependencies = new ArrayList<>();
    private final List<Property> properties = new ArrayList<>();
    @JsonIgnore
    private boolean additionalProperties;
    private String defaultValue;
    private String description;
    private String discriminator;
    private String discriminatorValue;
    private String example;
    private List<String> examples;
    private Number maxProperties;
    private Number minProperties;
    private String name;
    private boolean required;

    public BeanObject() {
    }

    public BeanObject(final String name) {
        this.name = WordUtils.capitalize(name);
    }

    public boolean isAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperties(boolean additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    public String getDefaultValue() {
        return this.defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public List<String> getDependencies() {
        return this.dependencies;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiscriminator() {
        return this.discriminator;
    }

    public void setDiscriminator(String discriminator) {
        this.discriminator = discriminator;
    }

    public String getDiscriminatorValue() {
        return this.discriminatorValue;
    }

    public void setDiscriminatorValue(String discriminatorValue) {
        this.discriminatorValue = discriminatorValue;
    }

    public String getExample() {
        return this.example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public List<String> getExamples() {
        return this.examples;
    }

    public void setExamples(List<String> examples) {
        this.examples = examples;
    }

    public Number getMaxProperties() {
        return this.maxProperties;
    }

    public void setMaxProperties(Number maxProperties) {
        this.maxProperties = maxProperties;
    }

    public Number getMinProperties() {
        return this.minProperties;
    }

    public void setMinProperties(Number minProperties) {
        this.minProperties = minProperties;
    }

    public String getName() {
        return this.name;
    }

    public List<Property> getProperties() {
        return this.properties;
    }

    public boolean isRequired() {
        return this.required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public Property getProperty(final String propName) {
        return this.properties.stream().filter(prop -> prop.getName().equals(propName)).findAny().orElse(null);
    }

    public void putProperty(final Property prop) {
        this.properties.add(prop);
        this.dependencies.addAll(prop.getDependencies());
    }

}
