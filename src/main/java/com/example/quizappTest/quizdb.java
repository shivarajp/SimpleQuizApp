package com.example.quizappTest;

/**
 * Created by raghav on 09/08/13.
 */
public class quizdb  {

    String ques,ans,opt1,opt2,opt3;
    String opt4;
public quizdb()
{

}
    public quizdb(quizdb a)
    {
         this.ques=a.ques;
        this.ans=a.ans;
        this.opt1=a.opt1;
        this.opt2=a.opt2;
        this.opt3=a.opt3;
        this.opt4=a.opt4;


    }
    public quizdb(String q,String a,String op1,String op2,String op3,String op4)
    {
        ques=q;
        ans=a;
        opt1=op1;
        opt2=op2;
        opt3=op3;
        opt4=op4;
    }
    public void setQues(String a)
    {
        ques=a;
    }
    public void setAns(String a)
    {
         ans=a;
    }
    public void setOpt1(String a)
    {
        opt1=a;
    }
    public void setOpt2(String a)
    {
        opt2=a;
    }
    public void setOpt3(String a)
    {
        opt3=a;
    }
    public void setOpt4(String a)
    {
        opt4=a;
    }

    public String getQues()
    {
        return ques;
    }
    public String getAns()
    {
        return ans;
    }
    public String getOpt1()
    {
        return opt1;
    }
    public String getOpt2()
    {
        return opt2;
    }
    public String getOpt3()
    {
        return opt3;
    }
    public String getOpt4()
    {
        return opt4;
    }
}
