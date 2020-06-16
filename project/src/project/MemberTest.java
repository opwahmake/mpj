package project;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class MemberTest {  static MemberDAO dao;
static Frame f;
static TextField name, sal,msg;
static Button btn;

public static void main(String[] args) {
   dao = new MemberDAO();//다른 클래스 호출인스턴스
   f = new Frame("사원정보 조회");//프레임 생성 이름은 "EMP"로
   f.setSize(460, 100);//프레임의 사이즈 설정
   f.setLayout(new FlowLayout());//레이아웃 종류 선언
   f.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
         System.exit(0);
      }
   });//닫기 버튼 활성화
   Label lid = new Label("name : ", Label.RIGHT);//라벨로 name : 이라는 글자를 출력하는 라벨 선언
   Label lpwd = new Label("salary : ", Label.RIGHT);//라벨로 salary : 라는 글자를 출력하는 라벨 선언
   name = new TextField(10);//name이라는 10칸짜리 텍스트 필드를 선언
   sal = new TextField(10);//sal이라는 10칸짜리 텍스트 필드를 선언
   msg=new TextField(40);
   msg.setEditable(false);
   //      sal.setEchoChar('*');
   btn = new Button("Login");//Login이라 쓰여진 btn버튼을 선언
   btn.addActionListener(new ActionListener() {//btn버튼을 눌렀을 경우 액션리스너를 호출
      public void actionPerformed(ActionEvent e) {//액션 퍼폼호출
         sal.setText("");//sal에 공란의 텍스트를 기입
         msg.setText("");
     
         System.out.println(name.getText());//name의 텍스트 필드에 있는 문자 를 호출
         System.out.println(sal.getText());//sal의 텍스트 필드에 있는 문자를 호출
         if(name.getText().equals(""))msg.setText("사원명을 입력하세요");
         else {
         ArrayList<MemberVo> list = dao.list(name.getText());
         if(list.size()==0)msg.setText("일치하는 사원명이 없습니다.");
         else msg.setText("조회 하였습니다.");
         for (int i = 0; i < list.size(); i++) {//list.size() 만큼 포문을 실행
            MemberVo data = (MemberVo) list.get(i);
            String empno = data.getEmpno();
            String ename = data.getEname();
            int iSal = data.getSal();
            sal.setText(Integer.toString(iSal));

            System.out.println(empno + " : " + ename + " : " + sal);
         }}
      }
   });

   f.add(lid);
   f.add(name);
   f.add(lpwd);
   f.add(sal);
   f.add(btn);
   f.add(msg);
   f.setVisible(true);

//   System.out.print("Input ename...?");
//   Scanner sc = new Scanner(System.in);
//   String inp = sc.next();
//
//   System.out.println(inp);
//   sc.close();
}
}
