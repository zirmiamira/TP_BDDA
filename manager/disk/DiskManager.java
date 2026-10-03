package manager.disk;

import manager.page.IPageId;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList; 

public class DiskManager {
    private String dmDir;
    private int pageSize;
    private int PageCount; 
    private ArrayList Pageslibres;
    private static final String NOMFICHIER = "fichier.bin";
	 public DiskManager(String dmDir, int pageSize) {
        this.dmDir = dmDir;
        this.pageSize = pageSize;
        this.PageCount = 1; 
        this.PagesLibres = new ArrayList<>();
    }
	void Init (String dmDir, int pageSize);
	void Save();
	IPageId AllocPage ();
	void ReadPage (IPageId ipid, ByteBuffer buffer);
	void WritePage (IPageId ipid, ByteBuffer buffer);
	void DeallocPage (IPageId ipid){
			if (ipid == null) {
            throw new RuntimeException("l'ID de la page est null");
        }

        int pageNum = ipid.getPageId();

        if (pageNum == 0) {
            throw new RuntimeException("impossible de libérer la Page 0 cer elle est réservé aux données");
        }

        if (pageNum < 0 || pageNum >= PageCount) {
            throw new RuntimeException("La page " + pageNum + " n'existe pas");
        }

        if (PagesLibres.contains(ipid)) {
            throw new RuntimeException("La page " + pageNum + " est déjà libérée");
        }

        PagesLibres.add(ipid);
		
	}

	
	

}
