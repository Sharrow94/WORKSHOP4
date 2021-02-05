package pl.maciejroszyk.app;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import pl.maciejroszyk.config.AppConfig;
import pl.maciejroszyk.repository.Book;
import pl.maciejroszyk.service.MemoryBookService;

public class AppInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() { return null; }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AppConfig.class};  }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};   }

    public static void main(String[] args) {

    }
}