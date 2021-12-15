package by.teachmeskills.JavaEE.postprocessor;

import by.teachmeskills.JavaEE.model.Human;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

public class BeanPostProcessorEx implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization " + beanName);
        if("human2".equals(beanName)) {
            Human humanBean = (Human) bean;
            System.out.println("HumanBean:" + humanBean.getLogin());
            humanBean.setLogin("BeforeLogin");
            return humanBean;
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization " + beanName);
        if("human2".equals(beanName)) {
            Human human = (Human) bean;
            System.out.println("HumanAfter " + human.getLogin());
            human.setLogin("AfterLogin");
            return human;
        }

        return bean;
    }
}
