package br.com.fabio.dnareader.dto.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DnaValidator implements
        ConstraintValidator<DnaConstraint, String[]> {

    private final Pattern notDnaRe = Pattern.compile("([^ACGT])");

    @Override
    public void initialize(DnaConstraint contactNumber) {
        // Nothing to do
    }

    @Override
    public boolean isValid(String[] dnaField, ConstraintValidatorContext cxt) {
        int element = 1;

        cxt.disableDefaultConstraintViolation();

        if (dnaField.length != 6){
            cxt.buildConstraintViolationWithTemplate("O array de DNA deve conter 6 elementos").addConstraintViolation();
            return false;
        }

        for (String dna:dnaField) {

            if (dna.length() != 6 ){
                cxt.buildConstraintViolationWithTemplate("O elemento " + element + " do array de DNA deve conter obrigatoriamente 6 bases nitrogenadas").addConstraintViolation();
                return false;
            }

            Matcher m = notDnaRe.matcher(dna);
            boolean isNotDNA = m.find();
            if ( isNotDNA ) {
                String messageError = "Base nitrogenada inválida: " +
                        m.group() +
                        ". Encontrada na posição " +
                        (m.start() + 1) +
                        " do elemento " +
                        element;
                cxt.buildConstraintViolationWithTemplate(messageError).addConstraintViolation();
                return false;
            }

            element++;

        }

        return true;

    }

}