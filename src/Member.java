import java.util.ArrayList;

public class Member {
    Member(ArrayList<String> str){
        this.nick= str.get(0);
        this.mbti=str.get(1);
        this.age=str.get(2);
        this.sch=str.get(3);
        this.maj=str.get(4);
        this.hgh=str.get(5);
        this.chr=str.get(6);
        this.sty=str.get(7);
        this.hob=str.get(8);
        this.intr=str.get(9);
    }

    private String nick; //닉네임
    private String mbti; //mbti
    private String age; //나이
    private String sch; //학교
    private String maj; //학과
    private String hgh; //키
    private String chr; //성격
    private String sty; //스타일
    private String hob; //취미
    private String intr; //자기소개

    String getNick(){
        return nick;
    }
    String getMbti(){
        return mbti;
    }
    String getAge(){
        return age;
    }
    String getSch(){
        return sch;
    }
    String getMaj(){
        return maj;
    }
    String getHgh(){ return hgh; }
    String getChr(){
        return chr;
    }
    String getSty(){
        return sty;
    }
    String getHob(){
        return hob;
    }
    String getIntr(){
        return intr;
    }

    String getAll_info(){
        StringBuffer sb = new StringBuffer();
        sb.append("닉네임 : "); sb.append(nick); sb.append("\n");
        sb.append("mbti : "); sb.append(mbti); sb.append("\n");
        sb.append("나이 : "); sb.append(age); sb.append("\n");
        sb.append("학교 : "); sb.append(sch); sb.append("\n");
        sb.append("학과 : "); sb.append(maj); sb.append("\n");
        sb.append("키 : "); sb.append(hgh); sb.append("\n");
        sb.append("성격 : "); sb.append(chr); sb.append("\n");
        sb.append("스타일 : "); sb.append(sty); sb.append("\n");
        sb.append("취미 : "); sb.append(hob); sb.append("\n");
        sb.append("자기소개 : "); sb.append(intr); sb.append("\n");
        return sb.toString();
    }
}

