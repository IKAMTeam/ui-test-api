package com.onevizion.uitest.api;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class LazyInitBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
        for (String beanName : beanFactory.getBeanDefinitionNames()) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
            String className = beanDefinition.getBeanClassName();
            if (className != null && className.startsWith("com.onevizion")
                    && !className.startsWith("com.onevizion.guitest") && !className.startsWith("com.onevizion.uitest")) {
                beanFactory.getBeanDefinition(beanName).setLazyInit(true);
            }
        }
    }

}