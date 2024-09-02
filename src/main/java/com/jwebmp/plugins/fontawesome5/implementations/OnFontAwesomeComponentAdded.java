package com.jwebmp.plugins.fontawesome5.implementations;

import com.jwebmp.core.base.angular.services.interfaces.IOnNgComponentAdded;
import com.jwebmp.core.base.html.interfaces.GlobalChildren;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;

public class OnFontAwesomeComponentAdded implements IOnNgComponentAdded<OnFontAwesomeComponentAdded>
{

    @Override
    public void onComponentAdded(IComponentHierarchyBase<GlobalChildren, ?> parent, IComponentHierarchyBase<GlobalChildren, ?> component)
    {
        /*if (component instanceof FontAwesome<?> fa)
        {
            IComponentHierarchyBase<?, ?> ngComponent = findOwningNgComponent(component);
            AnnotationHelper ah = IGuiceContext.get(AnnotationHelper.class);
            if (ngComponent == null)
            {
                //not ready yet, wait for adding to a component
                return;
            }

            ngComponent.addConfiguration(AnnotationUtils.getNgImportReference("FaIconLibrary", "@fortawesome/angular-fontawesome"));
            ngComponent.addConfiguration(AnnotationUtils.getNgImportReference("FaIconComponent", "@fortawesome/angular-fontawesome"));
        }*/
    }
}
