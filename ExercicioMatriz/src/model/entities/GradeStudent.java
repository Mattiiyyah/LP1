package model.entities;

import model.exceptions.GradeException;

public class GradeStudent {
    private Integer numberStudents;
    private float gradeStudent[][];

    final float LIMIT_TEN  = 10;
    final float LIMIT_ZERO = 0;

    public GradeStudent() {
    }

   public GradeStudent(int numberStudents) {
        this.numberStudents = numberStudents;
        this.gradeStudent = new float[numberStudents][3];
   }

    public Integer getNumberStudents() {
        return numberStudents;
    }

    public void setNumberStudents(Integer numberStudents) {
        this.numberStudents = numberStudents;
    }

    public float[][] getGradeStudent() {
        return gradeStudent;
    }

    public void setGradeStudent(float[][] gradeStudent) {
        this.gradeStudent = gradeStudent;
    }

    public void validationGrade(int student, int grade, float value) throws GradeException {
        if (value > LIMIT_TEN) {
           throw new GradeException("[ERRO] Nota não pode ser maior que 10!");
        }
        if (value < LIMIT_ZERO) {
            throw new GradeException("[ERRO] Nota não pode ser menor que 0!");
        }
        this.gradeStudent[student][grade] = value;  
    }

    public void viewStudent() {
        for(int i = 0; i < numberStudents; i++) {
            System.out.println("\n====================");
            System.out.println("      ALUNO " + (i + 1));
            System.out.println("====================");

            for(int j = 0; j < 3; j++) {
                System.out.println("Nota " + (j + 1) + " : " + gradeStudent[i][j]);
            }
        }
    }

    public void gradeScale() {
        for(int j = 0; j < 3; j++) {
            System.out.println("\n====================");
            System.out.println("      NOTA " + (j + 1));
            System.out.println("====================");

            float lowestGrade  = gradeStudent[0][j];
            float highestGrade = gradeStudent[0][j];
            int indexLowest = 0;
            int indexHighest = 0;

            for(int i = 0; i < numberStudents; i++) {

                 if(gradeStudent[i][j] > highestGrade) {
                    highestGrade = gradeStudent[i][j];
                    indexHighest = i;
                }

                if(gradeStudent[i][j] < lowestGrade) {
                    lowestGrade = gradeStudent[i][j];
                    indexLowest = i;
                }
            }

            System.out.println("nota " + (j+1) + " --> maior nota " +  highestGrade + ", do aluno " + (indexHighest + 1) + " | menor nota " + lowestGrade + " do aluno " + (indexLowest + 1));
        }
    }

}
