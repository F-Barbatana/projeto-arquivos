import React, { useEffect, useState } from 'react';
import { getDirectories, getFilesByDirectory } from './api'; // Certifique-se de importar corretamente
import './App.css';

const App = () => {
  const [directories, setDirectories] = useState([]);
  const [selectedDirectory, setSelectedDirectory] = useState(null);
  const [files, setFiles] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  // Buscar diretórios ao montar o componente
  useEffect(() => {
    const fetchDirectories = async () => {
      try {
        const data = await getDirectories();
        setDirectories(data);
      } catch (err) {
        setError(err.message);
      } finally {
        setLoading(false);
      }
    };

    fetchDirectories();
  }, []);

  // Função para buscar arquivos ao selecionar um diretório
  const fetchFiles = async (directoryId) => {
    setLoading(true);
    try {
      const filesData = await getFilesByDirectory(directoryId); // Aqui está a chamada correta
      setFiles(filesData);
    } catch (err) {
      setError(err.message);
    } finally {
      setLoading(false);
    }
  };



  if (loading) return <div>Loading...</div>;
  if (error) return <div>Error: {error}</div>;

  return (
    <div>
      <h1>Directories and Files</h1>

      <div className="directory-list">
        <h2>Directories</h2>
        <ul>
          {directories.map((dir) => (
            <li>
              {dir.name}
            </li>
          ))}
        </ul>
      </div>

      {selectedDirectory && (
        <div className="file-list">
          <h2>Files in Directory {selectedDirectory}</h2>
          {files.length === 0 ? (
            <p>No files in this directory.</p>
          ) : (
            <ul>
              {files.map((file) => (
                <li key={file.id}>{file.name}</li>
              ))}
            </ul>
          )}
        </div>
      )}
    </div>
  );
};

export default App;