package model;

/**
 *
 * @author tarun
 */
public class Book {
    
	protected int bid;
	protected String bname;
	protected String bauthor;
	protected String bprice;
        protected String bimage;
        protected String bdescription;
	
	public Book() {
	}
	
	public Book(String bname, String bauthor, String bprice, String bdescription, String bimage) {
		super();
		this.bname = bname;
		this.bauthor = bauthor;
		this.bprice = bprice;
                this.bdescription=bdescription;
                this.bimage=bimage;
	}

	public Book(int bid, String bname, String bauthor, String bprice, String bdescription, String bimage) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.bauthor = bauthor;
		this.bprice = bprice;
                this.bdescription=bdescription;
                this.bimage=bimage;
	}

        public int getBid() {
            return bid;
        }

        public void setBid(int bid) {
            this.bid = bid;
        }

        public String getBname() {
            return bname;
        }

        public void setBname(String bname) {
            this.bname = bname;
        }

        public String getBauthor() {
            return bauthor;
        }

        public void setBauthor(String bauthor) {
            this.bauthor = bauthor;
        }

        public String getBprice() {
            return bprice;
        }

        public void setBprice(String bprice) {
            this.bprice = bprice;
        }

        public String getBdescription() {
            return bdescription;
        }

        public void setBdescription(String bdescription) {
            this.bdescription = bdescription;
        }

        public String getBimage() {
            return bimage;
        }

        public void setBimage(String bimage) {
            this.bimage = bimage;
        }

	
    
}
