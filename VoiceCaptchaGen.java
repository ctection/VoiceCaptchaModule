package com.ctection.captchabot.ttmp3;

import com.sun.speech.freetts.audio.SingleFileAudioPlayer;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import javax.sound.sampled.AudioFileFormat;
import java.io.File;

public class VoiceCaptchaGen {
    /*
    Usage:
    -Create a new instace of VoiceCaptchaGen
        VoiceCaptchaGen voiceCaptchaGen = new VoiceCaptchaGen([Catpcha Text]);
    -Save Wave File including VoiceCaptcha
            voiceCaptchaGen.createWave([Path]);


     Note: if you set the path to e.g. "captcha", you will get a file called "captcha.wav"
            so you don't have to add the audio format

     */
    private static final String VOICENAME = "kevin16";
    private String captcha; // string to speech

    public VoiceCaptchaGen(String captcha) {
        this.captcha = captcha;
    }

    public File createWave(String path) {

        Voice voice;
        VoiceManager voiceManager = VoiceManager.getInstance();
        voice = voiceManager.getVoice(VOICENAME);
        voice.setRate(65);
        voice.allocate();
        SingleFileAudioPlayer audioPlayer = new SingleFileAudioPlayer(path, AudioFileFormat.Type.WAVE);
        voice.setAudioPlayer(audioPlayer);
        voice.speak(captcha);
        audioPlayer.close();


        return new File(path + ".wav");
    }


}
