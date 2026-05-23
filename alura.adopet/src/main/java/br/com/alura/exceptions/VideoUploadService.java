package br.com.alura.exceptions;

public class VideoUploadService {

    public static void main(String[] args) {
        System.out.println("[Inicio] - main");

        Video video = new Video("MeuVideo.mp4");
        User user = new User("André", video);

        VideoUploadService service = new VideoUploadService();
        service.processVideo(user);

        System.out.println("[Fim] - main");
    }

    public void processVideo(User user) {
        
    	System.out.println("[Início] processVideo");
       
        try {	
        	
        	processEncoding(user.getVideo());
		} catch (NullPointerException ex) {
			
			System.out.println("Vídeo não encontrado! " + ex.getMessage());
		}
        

        System.out.println("[Fim] processVideo");
    }

    private void processEncoding(Video video) {
        System.out.println("[Início] processEncoding");

        encodeVideo(video);

        System.out.println("[Fim] processEncoding");
    }

    private void encodeVideo(Video video) {
        System.out.println("[Início] encodeVideo");

        System.out.println("Detalhes da codificação: " + video.getEncodingDetails());

        System.out.println("[Fim] encodeVideo");
    }
}

class User {
    private String nome;
    private Video video;

    public User(String nome, Video video) {
        this.nome = nome;
        this.video = video;
    }

    public Video getVideo() {
        return video;
    }
}

class Video {
    private String nome;

    public Video(String nome) {
        this.nome = nome;
    }

    public String getEncodingDetails() {
        return "Codificando vídeo: " + nome;
    }
}






