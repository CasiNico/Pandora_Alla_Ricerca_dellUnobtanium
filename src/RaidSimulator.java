import Avatar.Avatar;
import PostazioneRDA.PostazioneRDA;
import Coordinata.Coordinata;
import java.util.Random;
import java.lang.Thread;

public class RaidSimulator {
    private Random random = new Random();
    private Avatar[] listaAvatar;
    private PostazioneRDA postazioneRDA;

    // liste per nomi e armi
    private String[] avatarNames = {
            "ShadowFox", "CyberKnight", "MysticFalcon", "NeonSpecter", "LunarWolf",
            "BlazePhantom", "StormRider", "EclipseHunter", "NovaStriker", "ThunderFang"
    };
    private String[] weapons = {
            "Shadow Blade", "Plasma Rifle", "Storm Breaker", "Dragon Fang Dagger", "Celestial Bow",
            "Inferno Gauntlets", "Frostmourne Spear", "Void Scythe", "Thunder Hammer", "Neon Katana"
    };

    public RaidSimulator(){
        listaAvatar = new Avatar[10];
        for(int i = 0; i < listaAvatar.length; i++){
            listaAvatar[i] = new Avatar(avatarNames[i], weapons[i]);
        }
        Coordinata coordinata = new Coordinata(random.nextInt(181) - 90, random.nextInt(361) - 180);
        postazioneRDA = new PostazioneRDA(coordinata);
        for(int i = 0; i < 11; i++){
            int dannoTurno = 0;
            for(int j = 0; j < 10; j++){
                dannoTurno += listaAvatar[j].attacca(postazioneRDA);
            }
            postazioneRDA.difendi(dannoTurno);
            dannoTurno = 0;
        }
    }
}
