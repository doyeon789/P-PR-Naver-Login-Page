package lang_signuppage_document.KR.Text_Doc_KR;

import javax.swing.*;
import java.awt.*;


public class PP_Agreement_KR {
    public PP_Agreement_KR(JPanel PP_agree_document) {
        JLabel PP_D1 = new JLabel(
                "<html>&nbsp;개인정보보호법에 따라 네이버에 회원가입 신청하시는 분께 "
                        + "<br>&nbsp;수집하는 개인정보의 항목, 개인정보의 수집 및 이용목적, "
                        + "<br>&nbsp;개인정보의 보유 및 이용기간, 동의 거부권 및 동의 거부 "
                        + "<br>&nbsp;시 불이익에 관한 사항을 안내 드리오니 자세히 읽은 후 "
                        + "<br>&nbsp;동의하여 주시기 바랍니다."
                        + "<br>&nbsp;"
        );
        PP_D1.setForeground(new Color(99, 99, 101));
        PP_D1.setFont(new Font("Dialog", Font.PLAIN, 13));

        JLabel PP_H1 = new JLabel(" 1. 수집하는 개인정보");
        PP_H1.setFont(new Font("Dialog", Font.BOLD, 15));

        JLabel PP_D2 = new JLabel(
                "<html>&nbsp;이용자는 회원가입을 하지 않아도 정보 검색, 뉴스 보기 등 "
                        + "<br>&nbsp;대부분의 네이버 서비스를 회원과 동일하게 이용할 수 있습"
                        + "<br>&nbsp;니다. 이용자가 메일, 캘린더, 카페, 블로그 등과 같이 개 "
                        + "<br>&nbsp;인화 혹은 회원제 서비스를 이용하기 위해 회원가입을 할 경"
                        + "<br>&nbsp;우, 네이버는 서비스 이용을 위해 필요한 최소한의 개인정보"
                        + "<br>&nbsp;를 수집합니다."
                        + "<br>"
                        + "<br>&nbsp;<b>회원가입 시점에 네이버가 이용자로부터 수집하는 개인정보</b>"
                        + "<br>&nbsp;<b>는 아래와 같습니다.</b>"
                        + "<br>&nbsp;- 회원 가입 시 필수항목으로 아이디, 비밀번호, 이름, "
                        + "<br>&nbsp;생년월일, 성별, 휴대전화번호를, 선택항목으로 이메일주소"
                        + "<br>&nbsp;를 수집합니다. 실명 인증된 아이디로 가입 시, 암호화된 "
                        + "<br>&nbsp;동일인 식별정보(CI), 중복가입 확인정보(DI), 내외국인 "
                        + "<br>&nbsp;정보를 함께 수집합니다. 만14세 미만 아동의 경우, 법정"
                        + "<br>&nbsp;대리인 정보(법정대리인의 이름, 중복가입확인정보(DI), "
                        + "<br>&nbsp;휴대전화번호)를 추가로 수집합니다."
                        + "<br>&nbsp;- 비밀번호 없이 회원 가입 시에는 필수항목으로 아이디, "
                        + "<br>&nbsp;이름, 생년월일, 휴대전화번호를, 선택항목으로 비밀번호를"
                        + "<br>&nbsp;수집합니다."
                        + "<br>&nbsp;"
                        + "<br>&nbsp;<b>서비스 이용 과정에서 이용자로부터 수집하는 개인정보는</b>"
                        + "<br>&nbsp;<b>아래와 같습니다.</b>"
                        + "<br>&nbsp;- 회원정보 또는 개별 서비스에서 프로필 정보(별명, 프로필"
                        + "<br>&nbsp;사진)를 설정할 수 있습니다. 회원정보에 별명을 입력하지 "
                        + "<br>&nbsp;않은 경우에는 마스킹 처리된 아이디가 별명으로 자동 "
                        + "<br>&nbsp;입력됩니다."
                        + "<br>&nbsp;- 네이버 내의 개별 서비스 이용, 이벤트 응모 및 경품 "
                        + "<br>&nbsp;신청 과정에서 해당 서비스의 이용자에 한해 추가 개인정보"
                        + "<br>&nbsp;수집이 발생할 수 있습니다. 추가로 개인정보를 수집할 경우"
                        + "<br>&nbsp;에는 해당 개인정보 수집 시점에서 이용자에게 ‘수집하는 "
                        + "<br>&nbsp;개인정보 항목, 개인정보의 수집 및 이용목적, 개인정보의 "
                        + "<br>&nbsp;보관기간’에 대해 안내 드리고 동의를 받습니다."
                        + "<br>&nbsp;"
                        + "<br>&nbsp;<b>서비스 이용 과정에서 IP 주소, 쿠키, 서비스 이용 기록,</b>"
                        + "<br>&nbsp;<b>기기정보, 위치정보가 생성되어 수집될 수 있습니다. 또한 </b>"
                        + "<br>&nbsp;<b>이미지 및 음성을 이용한 검색 서비스 등에서 이미지나 </b>"
                        + "<br>&nbsp;<b>음성이 수집될 수 있습니다.</b>"
                        + "<br>&nbsp;구체적으로 1) 서비스 이용 과정에서 이용자에 관한 정보를"
                        + "<br>&nbsp;자동화된 방법으로 생성하여 이를 저장(수집)하거나, 2)"
                        + "<br>&nbsp;이용자 기기의 고유한 정보를 원래의 값을 확인하지 못 "
                        + "<br>&nbsp;하도록 안전하게 변환하여 수집합니다."
                        + "<br>&nbsp;서비스 이용 과정에서 위치정보가 수집될 수 있으며,"
                        + "<br>&nbsp;네이버에서 제공하는 위치기반 서비스에 대해서는 '네이버 "
                        + "<br>&nbsp;위치기반서비스 이용약관'에서 자세하게 규정하고 있습니다."
                        + "<br>&nbsp;이와 같이 수집된 정보는 개인정보와의 연계 여부 등에 따라 "
                        + "<br>&nbsp;개인정보에 해당할 수 있고, 개인정보에 해당하지 않을 수"
                        + "<br>&nbsp;도 있습니다."
                        + "<br>"
                        + "<br>&nbsp;<b>생성정보 수집에 대한 추가 설명</b>"
                        + "<br>&nbsp;- IP(Internet Protocol) 주소란?"
                        + "<br>&nbsp;IP 주소는 인터넷 망 사업자가 인터넷에 접속하는 이용자의"
                        + "<br>&nbsp;PC 등 기기에 부여하는 온라인 주소정보 입니다. IP 주"
                        + "<br>&nbsp;소가 개인정보에 해당하는지 여부에 대해서는 각국마다 매우"
                        + "<br>&nbsp;다양한 견해가 있습니다."
                        + "<br>&nbsp;- 서비스 이용기록이란?"
                        + "<br>&nbsp;네이버 접속 일시, 이용한 서비스 목록 및 서비스 이용 과"
                        + "<br>&nbsp;정에서 발생하는 정상 또는 비정상 로그 일체,메일 수발신"
                        + "<br>&nbsp;과정에서 기록되는 이메일주소, 친구 초대하기 또는 선물하"
                        + "<br>&nbsp;기 등에서 입력하는 휴대전화번호, 스마트스토어 판매자와"
                        + "<br>&nbsp;구매자간 상담내역(네이버톡톡 및 상품 Q&A 게시글) 등을"
                        + "<br>&nbsp;의미합니다."
                        + "<br>&nbsp;- 기기정보란?"
                        + "<br>&nbsp;본 개인정보처리방침에 기재된 기기정보는 생산 및 판매 과"
                        + "<br>&nbsp;정에서 기기에 부여된 정보뿐 아니라, 기기의 구동을 위해"
                        + "<br>&nbsp;사용되는 S/W를 통해 확인 가능한 정보를 모두 일컫습니다."
                        + "<br>&nbsp;OS(Windows, MAC OS 등) 설치 과정에서 이용자가 PC"
                        + "<br>&nbsp;에 부여하는 컴퓨터의 이름, PC에 장착된 주변기기의 일련"
                        + "<br>&nbsp;번호, 스마트폰의 통신에 필요한 고유한 식별값(IMEI,"
                        + "<br>&nbsp;IMSI), AAID 혹은 IDFA, 설정언어 및 설정 표준시,"
                        + "<br>&nbsp;USIM의 통신사 코드 등을 의미합니다. 단, 네이버는"
                        + "<br>&nbsp;IMEI와 같은 기기의 고유한 식별값을 수집할 필요가 있는"
                        + "<br>&nbsp;경우, 이를 수집하기 전에 네이버도 원래의 값을 알아볼"
                        + "<br>&nbsp;수 없는 방식으로 암호화 하여 식별성"
                        + "<br>&nbsp;(Identifiability)을 제거한 후에 수집합니다."
                        + "<br>&nbsp;- 쿠키(cookie)란?"
                        + "<br>&nbsp;쿠키는 이용자가 웹사이트를 접속할 때에 해당 웹사이트에서"
                        + "<br>&nbsp;이용자의 웹브라우저를 통해 이용자의 PC에 저장하는 매우"
                        + "<br>&nbsp;작은 크기의 텍스트 파일입니다. 이후 이용자가 다시"
                        + "<br>&nbsp;웹사이트를 방문할 경우 웹사이트 서버는 이용자 PC에 저장"
                        + "<br>&nbsp;된 쿠키의 내용을 읽어 이용자가 설정한 서비스 이용 환경을"
                        + "<br>&nbsp;유지하여 편리한 인터넷 서비스 이용을 가능케 합니다. 또한"
                        + "<br>&nbsp;방문한 서비스 정보, 서비스 접속 시간 및 빈도, 서비스 이"
                        + "<br>&nbsp;용 과정에서 생성된 또는 제공(입력)한 정보 등을 분석하여"
                        + "<br>&nbsp;이용자의 취향과 관심에 특화된 서비스(광고 포함)를 제공할"
                        + "<br>&nbsp;수 있습니다. 이용자는 쿠키에 대한 선택권을 가지고 있으며,"
                        + "<br>&nbsp;웹브라우저에서 옵션을 설정함으로써 모든 쿠키를 허용하거나,"
                        + "<br>&nbsp;쿠키가 저장될 때마다 확인을 거치거나, 아니면 모든 쿠키의"
                        + "<br>&nbsp;저장을 거부할 수도 있습니다. 다만, 쿠키의 저장을 거부할"
                        + "<br>&nbsp;경우에는 로그인이 필요한 네이버 일부 서비스의 이용에 불편"
                        + "<br>&nbsp;이 있을 수 있습니다."
                        + "<br>"
                        + "<br>"
        );
        PP_D2.setForeground(new Color(99, 99, 101));
        PP_D2.setFont(new Font("Dialog", Font.PLAIN, 13));

        JLabel PP_H2 = new JLabel(" 2. 수집한 개인정보의 이용");
        PP_H2.setFont(new Font("Dialog", Font.BOLD, 15));

        JLabel PP_D3 = new JLabel(
                "<html>&nbsp;네이버 및 네이버 관련 제반 서비스(모바일 웹/앱 포함)의"
                        + "<br>&nbsp;회원관리, 서비스 개발・제공 및 향상, 안전한 인터넷 이용"
                        + "<br>&nbsp;환경 구축 등 아래의 목적으로만 개인정보를 이용합니다."
                        + "<br>&nbsp;- 회원 가입 의사의 확인, 연령 확인 및 법정대리인 동의"
                        + "<br>&nbsp;진행, 이용자 및 법정대리인의 본인 확인, 이용자 식별,"
                        + "<br>&nbsp;회원탈퇴 의사의 확인 등 회원관리를 위하여 개인정보를"
                        + "<br>&nbsp;이용합니다."
                        + "<br>&nbsp;- 콘텐츠 등 기존 서비스 제공(광고 포함)에 더하여,"
                        + "<br>&nbsp;인구통계학적 분석, 서비스 방문 및 이용기록의 분석, 개"
                        + "<br>&nbsp;인정보 및 관심에 기반한 이용자간 관계의 형성, 지인 및"
                        + "<br>&nbsp;관심사 등에 기반한 맞춤형 서비스 제공 등 신규 서비스"
                        + "<br>&nbsp;요소의 발굴 및 기존 서비스 개선 등을 위하여 개인정보를"
                        + "<br>&nbsp;이용합니다."
                        + "<br>&nbsp;- 법령 및 네이버 이용약관을 위반하는 회원에 대한 이용"
                        + "<br>&nbsp;제한 조치, 부정 이용 행위를 포함하여 서비스의 원활한"
                        + "<br>&nbsp;운영에 지장을 주는 행위에 대한 방지 및 제재, 계정도용"
                        + "<br>&nbsp;및 부정거래 방지, 약관 개정 등의 고지사항 전달, 분쟁"
                        + "<br>&nbsp;조정을 위한 기록 보존, 민원처리 등 이용자 보호 및 서"
                        + "<br>&nbsp;비스 운영을 위하여 개인정보를 이용합니다."
                        + "<br>&nbsp;- 유료 서비스 제공에 따르는 본인인증, 구매 및 요금 결"
                        + "<br>&nbsp;제, 상품 및 서비스의 배송을 위하여 개인정보를 이용합니다."
                        + "<br>&nbsp;"
                        + "<br>&nbsp;<b>- 이벤트 정보 및 참여기회 제공, 광고성 정보 제공 등 마</b>"
                        + "<br>&nbsp;<b> 케팅 및 프로모션 목적으로 개인정보를 이용합니다.</b>"
                        + "<br>&nbsp;-서비스 이용기록과 접속 빈도 분석, 서비스 이용에 대한 "
                        + "<br>&nbsp;통계, 서비스 분석 및 통계에 따른 맞춤 서비스 제공 및 "
                        + "<br>&nbsp;광고 게재 등에 개인정보를 이용합니다."
                        + "<br>&nbsp;- 보안, 프라이버시, 안전 측면에서 이용자가 안심하고 이"
                        + "<br>&nbsp;용할 수 있는 서비스 이용환경 구축을 위해 개인정보를 이"
                        + "<br>&nbsp;용합니다."
                        + "<br>&nbsp;"
        );
        PP_D3.setForeground(new Color(99, 99, 101));
        PP_D3.setFont(new Font("Dialog", Font.PLAIN, 13));


        JLabel PP_H3 = new JLabel(" 3. 개인정보의 보관기간");
        PP_H3.setFont(new Font("Dialog", Font.BOLD, 15));

        JLabel PP_D4 = new JLabel(
                "<html>&nbsp;"
                        + "<br>&nbsp;<b>회사는 원칙적으로 이용자의 개인정보를 회원 탈퇴 시 지체</b>"
                        + "<br>&nbsp;<b>없이 파기하고 있습니다.</b>"
                        + "<br>&nbsp;<b>단, 이용자에게 개인정보 보관기간에 대해 별도의 동의를</b>"
                        + "<br>&nbsp;<b>얻은 경우, 또는 법령에서 일정 기간 정보보관 의무를 부</b>"
                        + "<br>&nbsp;<b>과하는 경우에는 해당 기간 동안 개인정보를 안전하게 보</b>"
                        + "<br>&nbsp;<b>관합니다.</b>"
                        + "<br>&nbsp;<b></b>"
                        + "<br>&nbsp;<b>이용자에게 개인정보 보관기간에 대해 회원가입 시 또는 서/b>"
                        + "<br>&nbsp;<b> 비스 가입 시 동의를 얻은 경우는 아래와 같습니다.</b>"
                        + "<br>&nbsp;- 전자상거래 등에서 소비자 보호에 관한 법률"
                        + "<br>&nbsp;계약 또는 청약철회 등에 관한 기록: 5년 보관"
                        + "<br>&nbsp;대금결제 및 재화 등의 공급에 관한 기록: 5년 보관"
                        + "<br>&nbsp;소비자의 불만 또는 분쟁처리에 관한 기록: 3년 보관"
                        + "<br>&nbsp;-전자문서 및 전자거래 기본법"
                        + "<br>&nbsp;공인전자주소를 통한 전자문서 유통에 관한 기록:  10년 "
                        + "<br>&nbsp;보관"
                        + "<br>&nbsp;- 통신비밀보호법"
                        + "<br>&nbsp;로그인 기록: 3개월"
                        + "<br>"
                        + "<br>"
        );
        PP_D4.setForeground(new Color(99, 99, 101));
        PP_D4.setFont(new Font("Dialog", Font.PLAIN, 13));

        JLabel PP_H4 = new JLabel(" 4. 개인정보 수집 및 이용 동의를 거부할 권리");
        PP_H4.setFont(new Font("Dialog", Font.BOLD, 15));

        JLabel PP_D5 = new JLabel(
            "<html>&nbsp;이용자는 개인정보의 수집 및 이용 동의를 거부할 권리가 "
                    +"<br>&nbsp;있습니다. 회원가입 시 수집하는 최소한의 개인정보, 즉, "
                    +"<br>&nbsp;필수 항목에 대한 수집 및 이용 동의를 거부하실 경우, "
                    +"<br>&nbsp;회원가입이 어려울 수 있습니다."
        );

        PP_agree_document.setLayout(new BoxLayout(PP_agree_document, BoxLayout.Y_AXIS));
        PP_agree_document.add(PP_D1);
        PP_agree_document.add(PP_H1);
        PP_agree_document.add(PP_D2);
        PP_agree_document.add(PP_H2);
        PP_agree_document.add(PP_D3);
        PP_agree_document.add(PP_H3);
        PP_agree_document.add(PP_D4);
        PP_agree_document.add(PP_D5);
    }
}
//ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ
//ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ

// + "<br>&nbsp;&nbsp;&nbsp;· "
// + "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
// + "<br>&nbsp;"

//setForeground(new Color(99, 99, 101));
//setFont(new Font("Dialog", Font.PLAIN, 13));

//setFont(new Font("Dialog", Font.BOLD, 15));