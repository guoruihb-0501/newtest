package com.future.test;

/**
 * @author guorui
 * @create 2022-04-29-15:19
 */
public class GradeWord {

    private String wordEng;
    private String wordChn;
    private String example;
    private String chapter;
    private Integer seq;
    private String sign2;

    public GradeWord() {
    }

    public GradeWord(String wordEng, String wordChn, String example, String chapter, Integer seq, String sign2) {
        this.wordEng = wordEng;
        this.wordChn = wordChn;
        this.example = example;
        this.chapter = chapter;
        this.seq = seq;
        this.sign2 = sign2;
    }

    @Override
    public String toString() {
        return "GradeWord{" +
                "wordEng='" + wordEng + '\'' +
                ", wordChn='" + wordChn + '\'' +
                ", example='" + example + '\'' +
                ", chapter='" + chapter + '\'' +
                ", seq=" + seq +
                ", sign2='" + sign2 + '\'' +
                '}';
    }

    public String getWordEng() {
        return wordEng;
    }

    public void setWordEng(String wordEng) {
        this.wordEng = wordEng;
    }

    public String getWordChn() {
        return wordChn;
    }

    public void setWordChn(String wordChn) {
        this.wordChn = wordChn;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getSign2() {
        return sign2;
    }

    public void setSign2(String sign2) {
        this.sign2 = sign2;
    }
}
