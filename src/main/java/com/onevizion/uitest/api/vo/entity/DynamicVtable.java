package com.onevizion.uitest.api.vo.entity;

import java.util.List;

import com.onevizion.uitest.api.exception.SeleniumUnexpectedException;

public class DynamicVtable {

    private String name;
    private String desc;
    private List<DynamicVtableValue> values;

    private List<String> packages;

    private DynamicVtable() {
        
    }

    public static Builder newBuilder() {
        return new DynamicVtable().new Builder();
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public List<DynamicVtableValue> getValues() {
        return values;
    }

    public List<String> getPackages() {
        return packages;
    }

    public class Builder {

        private Builder() {
            
        }

        public DynamicVtable build() {
            if (DynamicVtable.this.name == null ||
                    DynamicVtable.this.desc == null ||
                    DynamicVtable.this.values == null ||
                    DynamicVtable.this.packages == null) {
                throw new SeleniumUnexpectedException("");
            }
            return DynamicVtable.this;
        }

        public Builder setName(String name) {
            DynamicVtable.this.name = name;
            return this;
        }

        public Builder setDesc(String desc) {
            DynamicVtable.this.desc = desc;
            return this;
        }

        public Builder setValues(List<DynamicVtableValue> values) {
            DynamicVtable.this.values = values;
            return this;
        }

        public Builder setPackages(List<String> packages) {
            DynamicVtable.this.packages = packages;
            return this;
        }

    }

}