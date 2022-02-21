<template>
  <div id="myInfoPage">
    <div class="content_wrap">
      <h2>회원정보관리</h2>

      <table>
        <colgroup width="15%"></colgroup>
        <colgroup width="85%"></colgroup>
        <tbody>
          <tr>
            <th scope="row">이름</th>
            <td v-if="!onAuth">{{ userInfo.name }}</td>
            <td v-else>
              <input type="text" v-model="userInfo.name" />
            </td>
          </tr>
          <tr>
            <th scope="row">사진<br />&<br />닉네임</th>
            <td v-if="!onAuth" class="img_td">
              <div>
                <div class="img_wrap">
                  <img
                    src="@/assets/images/member_profile-img.png"
                    alt="profile_img"
                  />
                </div>
                <div>{{ userInfo.nick }}</div>
              </div>
            </td>
            <td v-else class="img_td">
              <div>
                <div class="img_wrap">
                  <img
                    src="@/assets/images/member_profile-img.png"
                    alt="profile_img"
                  />
                </div>
                <div>
                  <input
                    type="text"
                    v-model="userInfo.nick"
                    placeholder="닉네임을 입력해 주세요."
                  />
                  <div>
                    <button onClick="onClickUpdateImgBtn">변경</button>
                    <button onClick="onClickDeleteImgBtn">삭제</button>
                  </div>
                </div>
              </div>
            </td>
          </tr>
          <tr>
            <th scope="row">비밀번호</th>
            <td v-if="!onAuth">
              '변경' 버튼 클릭시 인증 후 변경 가능
            </td>
            <td v-else>
              <input type="password" v-model="userInfo.pw" />
            </td>
          </tr>
          <tr v-if="onAuth">
            <th scope="row">비밀번호 확인</th>
            <td>
              <input type="password" v-model="userInfo.pwCheck" />
            </td>
          </tr>
          <tr>
            <th scope="row">이메일</th>
            <td>{{ userInfo.eMail }}</td>
          </tr>
          <tr>
            <th scope="row">연락처</th>
            <td>{{ userInfo.phone }}</td>
          </tr>
          <tr>
            <th scope="row">생년월일</th>
            <td>{{ userInfo.birth }}</td>
          </tr>
          <tr>
            <th scope="row">성별</th>
            <td>{{ userInfo.sex }}</td>
          </tr>
        </tbody>
      </table>

      <div class="btn_wrap" :class="{ 'on-auth': onAuth }">
        <button v-if="!onAuth">회원정보 변경</button>
        <button v-else>적용</button>
        <button v-if="onAuth">취소</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      onAuth: false,

      basicUserInfo: {}, // login 기본정보
      userInfo: {
        name: undefined,
        img: undefined,
        nick: undefined,
        pw: undefined,
        pwCheck: undefined,
        eMail: undefined,
        phone: undefined,
        birth: undefined,
        sex: undefined,
      }, // 회원 상세정보
    };
  },
  computed: {
    // login 통한 기본 user정보 가져오기 (from vuex)
  },

  created() {
    this.go();
  },

  methods: {
    // async go() {
    //   this.userInfo = await this.$http.get('', {
    //     params: {
    //       foo: 'bar',   // login 기본 user정보 이용(* email 등)
    //     },
    //   });
    // },
    go() {
      this.userInfo = {
        name: "손흥민",
        img: "",
        nick: "Sonny_7",
        pw: "",
        pwCheck: "",
        eMail: "sonny_7@gmail.com",
        phone: "010-1234-5678",
        birth: "19920708",
        sex: "mail",
      };
    },
  },
};
</script>

<style></style>
