package Task1.Workshop9.Jac444;

import java.util.HashSet;
public class Answer {

    private HashSet<Number>[] qGuesses;

    public  Answer(){
        this.qGuesses= new HashSet[4];
        for(int i=0;i<this.qGuesses.length;i++)
            this.qGuesses[i] = new HashSet<>();

    }



    public boolean checkGuesses(int question, Number value){
        boolean valid= false;

        if(question >=0 && question<this.qGuesses.length){
            valid= this.qGuesses[question].contains(value);
        }
        return valid;
    }

    public void clearGuesses(){
        for(int i=0;i<this.qGuesses.length;i++)
            this.qGuesses[i].clear();
    }


    public  int checkAnswers(NumberPair pair,Number...answers){
        int correctCount=0;
        if(pair.add()==answers[0].intValue()){
            correctCount++;
        }else{
            this.qGuesses[0].add(answers[0]);
        }
        if(pair.sub()==answers[1].intValue()){
            correctCount++;
        }else{
            this.qGuesses[1].add(answers[1]);
        }
        if(pair.multiply()==answers[2].intValue()){
            correctCount++;
        }{
            this.qGuesses[2].add(answers[2]);
        }
        if(Math.round(pair.divide()*100)==Math.round(answers[3].doubleValue()*100)){
            correctCount++;
        }else {
            this.qGuesses[3].add(answers[3]);
        }


        return correctCount;

    }


    public int questions(){
        return this.qGuesses.length;
    }


}
