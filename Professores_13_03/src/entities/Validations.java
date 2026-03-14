package entities;

public class Validations {
    private int scores[] = new int[3];  
    private String candidates[] = new String[3]; 
    private int candidateCounter = 0;

    public Validations() {
    }

    public Validations(int[] scores, String[] candidates, int candidateCounter) {
        this.scores = scores;
        this.candidates = candidates;
        this.candidateCounter = candidateCounter;
    }
   
    public int[] getScores() {
        return scores;
    }

    public String[] getCandidates() {
        return candidates;
    }

    public int getCandidateCounter() {
        return candidateCounter;
    }

    public void setScores(int[] scores) {
        this.scores = scores;
    }

    public void setCandidates(String[] candidates) {
        this.candidates = candidates;
    }

    public void setCandidateCounter(int candidateCounter) {
        this.candidateCounter = candidateCounter;
    }

    public int calculateScore(int age, int timeExperience,  int area) {    
        switch (area) {
            case 1:
                area = 5;
                break;
        
            case 2: 
               area = 10;
               break;
            case 3:
                area = 15;
                break;
        }

        int score = (age / 2) + (timeExperience * 3) + area;
        return score;
    }

    @Override
    public String toString() {
        String result = "\n========== Top 3 Candidates ==========\n";
        for (int i = 0; i < scores.length; i++) {
            if (candidates[i] != null) {
                result += (i + 1) + "° - Name: " + candidates[i] + " | Score: " + scores[i] + "\n";
            }
        }
        result += "Total candidates registered: " + candidateCounter + "\n";
        result += "=======================================\n";
        return result;
    }
}
