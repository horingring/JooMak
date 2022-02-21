<template>
  <div id="myInfoPage" :class="{ 'on-auth': onAuth }">
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
                  <div class="btn_wrap">
                    <button @click="onClickUpdateImgBtn" class="change">
                      변경
                    </button>
                    <button @click="onClickDeleteImgBtn" class="delete">
                      삭제
                    </button>
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
              <input
                type="password"
                v-model="userInfo.pw"
                placeholder="새로운 비밀번호를 입력해 주세요."
              />
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
            <td>{{ userInfo.sex === "male" ? "남" : "여" }}</td>
          </tr>
        </tbody>
      </table>

      <div class="btn_wrap">
        <button v-if="!onAuth" @click="onClickChangeInfoBtn">
          회원정보 변경
        </button>
        <button v-else class="apply" @click="onClickApplyBtn">적용</button>
        <button v-if="onAuth" class="cancel" @click="onClickCancelBtn">
          취소
        </button>
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

      tmpUserInfo: {},
    };
  },
  computed: {
    // login 통한 기본 user정보 가져오기 (from vuex)
  },

  created() {
    this.onAuth = false;

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
        sex: "male",
      };

      // deep copy
      this.tmpUserInfo = JSON.parse(JSON.stringify(this.userInfo));
    },

    /**
     * 이미지 변경버튼 클릭시
     */
    onClickUpdateImgBtn() {
      console.log("이미지 변경 btn 클릭");
    },
    /**
     * 이미지 삭제버튼 클릭시
     */
    onClickDeleteImgBtn() {
      console.log("이미지 삭제 btn 클릭");
    },

    /**
     * 회원정보 변경버튼 클릭시
     */
    onClickChangeInfoBtn() {
      this.onAuth = true;
    },

    /**
     * 적용버튼 클릭시
     */
    onClickApplyBtn() {
      console.log("적용 btn 클릭");
    },
    /**
     * 취소버튼 클릭시
     */
    onClickCancelBtn() {
      this.onAuth = false;
      this.userInfo = this.tmpUserInfo;
      scrollTo(0, 0);
    },
  },
};
</script>

<style></style>
