package br.com.fapen.estoque.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.fapen.estoque.form.AlteraSenhaForm;

@Component
public class AlteraSenhaFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return AlteraSenhaForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "novaSenha", "campo.obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "novaSenhaConfirma", "campo.obrigatorio");

		AlteraSenhaForm formulario = (AlteraSenhaForm) target;
		
		if (!formulario.getNovaSenha().equals(formulario.getNovaSenhaConfirma())) {
			errors.rejectValue("novaSenha", "senha.nao.confere");
		}
	}
}
