package su.vistar.sample.editors;

import su.vistar.sample.dto.regular.RoleDto;

import java.beans.PropertyEditorSupport;

public class RoleEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String id) {
        RoleDto roleDto = null;
        switch (Integer.parseInt(id)) {
            case 1:
                roleDto = new RoleDto(1, "ADMIN");
                break;
            case 2:
                roleDto = new RoleDto(2, "DOCTOR");
                break;
            case 3:
                roleDto = new RoleDto(3, "CLIENT");
                break;
        }
        this.setValue(roleDto);
    }

}
