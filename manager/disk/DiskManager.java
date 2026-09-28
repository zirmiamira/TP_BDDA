package manager.disk;

import manager.page.IPageId;

public class DiskManager {

	
	void Init (String dmDir, int pageSize);
	void Save();
	IPageId AllocPage ();
	void ReadPage (IPageId ipid, ByteBuffer buffer);
	void WritePage (IPageId ipid, ByteBuffer buffer);
	void DeallocPage (IpageId ipid);
	

}
