package com.tsunagi.app.domain.advisor;

import com.tsunagi.app.constant.gender.Gender;
import com.tsunagi.app.constant.expertise.Expertise;
import com.tsunagi.app.constant.gender.GenderConverter;
import com.tsunagi.app.domain.BaseTimeEntity;
import com.tsunagi.app.domain.career.Career;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Advisor extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 254, nullable = false)
    private String mail;

    @Column(length = 30, nullable = false)
    private String name;

    @OneToMany(mappedBy = "advisor")
    private List<Career> careers;

    @Column(nullable = false)
    private long age;

    // TODO: Enum型を使えるかを確認する必要がある。
    @Column(nullable = false)
    @Convert(converter = GenderConverter.class)
    private Gender gender;

    @Column(length = 300, nullable = true)
    private String introduce;

    @Convert(converter = Expertise.class)
    private Expertise expertise;

    private long isDeleted;

    // TODO: 今後、プロフィル写真を追加したら画像パスを保存する。
//    @Column(nullable = false)
//    private String profilePicturePath;

    // TODO: 今後、アドバイザー評価の項目を追加する。（テーブル作成方法について調べる必要あり）

    @Builder
    public Advisor(String mail, String name, long age, List<Career> careers, Gender gender, String introduce, Expertise expertise, long isDeleted) {
        this.mail = mail;
        this.name = name;
        this.age = age;
        this.careers = careers;
        this.gender = gender;
        this.introduce = introduce;
        this.expertise = expertise;
        this.isDeleted = isDeleted;
    }
}
