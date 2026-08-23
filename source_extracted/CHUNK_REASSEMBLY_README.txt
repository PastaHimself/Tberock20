FULL DECOMPRESSED MOD - CHUNKED DOWNLOAD

All original JAR files are present across these ZIPs.
One oversized original file was split into numbered .partNNN pieces:
  sites/rblog/file.bin

To reconstruct it on Linux/macOS after extracting all ZIPs into one folder:
  cat sites/rblog/file.bin.part001 sites/rblog/file.bin.part002 sites/rblog/file.bin.part003 > sites/rblog/file.bin

On Windows PowerShell:
  $parts = 1..3 | ForEach-Object { "sites/rblog/file.bin.part{0:D3}" -f $_ }
  $out = [System.IO.File]::Create('sites/rblog/file.bin')
  foreach ($p in $parts) { $bytes=[System.IO.File]::ReadAllBytes($p); $out.Write($bytes,0,$bytes.Length) }
  $out.Close()

Delete the .partNNN files only after verifying the reconstructed file.
