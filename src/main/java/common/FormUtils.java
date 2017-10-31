package common;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Author: sazal
 * Date: 10/23/17
 */
public class FormUtils {

    private FormUtils() {
    }

    /**
     * This method is intended to create a {@link Form} object.
     * It accepts a http request and a concrete implementation of {@link Form} type.
     * Then it try to bind the request parameters which contains the submitted form from UI
     * with the given {@link Form} given as clazz parameter.
     *
     * @param   request a http request of type {@link HttpServletRequest}
     * @param   clazz a class of type {@link Form}
     * @return  a {@link Form} object of given type as clazz argument or null if it can't create
     */
    public static <T extends Form> T getForm(HttpServletRequest request, Class<T> clazz) {
        return bindForm(request.getParameterMap(), clazz);
    }

    /**
     * This method is intended to create a {@link Form} object.
     * It accepts a map and a concrete implementation of {@link Form} type.
     * Then it try to bind the request parameters which contains the submitted form from UI
     * with the given {@link Form} given as clazz parameter. This method is a convenient method
     * to be used internally. It uses {@link BeanUtils} underneath to populate the {@link Form}
     *
     * @param   parameterMap a map
     * @param   form a class of type {@link Form}
     * @return  a {@link Form} object of given type as clazz argument or null if it can't create
     */
    private static <T extends Form> T bindForm(Map parameterMap, Class<T> form) {
        T formInstance = null;
        try {
            formInstance = form.newInstance();
            BeanUtils.populate(formInstance, parameterMap);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return formInstance;
    }
}
