public Huffman {
	public static int offset = 0;
	
	// Huff_putBit
	// returns new offset;
	public static void putBit(int bit, byte[] fout) {
		if ((offset & 7) == 0) {		// first three bits are not set
			fout[(offset >> 3)] = 0
		}
		fout[ (offset >> 3) ] |= bit << (offset & 7);
		offset++;
	}
	
	// Huff_getBit
	// returns bit
	public static int getBit(byte[] fin) {
		return ( fin[ ( offset >> 3 ) ] >> ( offset++ & 7 ) ) & 0x1;	// increments offset after;
	}
	
	// Huff_add_bit
	// adds bit
	public static void addBit(char bit, byte[] fout) {
		if ( ( offset & 7 ) == 0 ) {
			fout[ ( offset >> 3 ) ] = 0;
		}
		fout[ ( offset >> 3 ) ] |= bit << ( offset & 7 );
		offset++;
	}
	
	public static void addBit(char bit, byte[] fout) {
		if ( ( offset & 7 ) == 0 ) {
			fout[ ( offset >> 3 ) ] = 0;
		}
		fout[ ( offset >> 3 ) ] |= bit << ( offset & 7 );
		offset++;
	}
}