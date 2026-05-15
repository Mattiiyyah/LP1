// ============================================
// ATENDIMENTO CLÍNICO - Dashboard App
// ============================================

document.addEventListener('DOMContentLoaded', () => {
  loadData();
});

async function loadData() {
  const container = document.getElementById('app-content');
  container.innerHTML = `
    <div class="loading">
      <div class="loading-spinner"></div>
      <div class="loading-text">Carregando dados clínicos...</div>
    </div>`;

  try {
    const response = await fetch('./dados.json');
    if (!response.ok) throw new Error('Arquivo não encontrado');
    const data = await response.json();
    renderDashboard(data, container);
  } catch (err) {
    container.innerHTML = `
      <div class="error-state">
        <div class="error-icon">⚠️</div>
        <h3>Erro ao carregar dados</h3>
        <p>Certifique-se de que o <strong>App.java</strong> foi executado para gerar o arquivo <strong>dados.json</strong>, e que esta página está sendo servida por um servidor local.</p>
      </div>`;
  }
}

function renderDashboard(data, container) {
  let html = '';

  // Admin card
  if (data.admin) {
    html += renderAdmin(data.admin);
  }

  // Stats row
  html += renderStats(data);

  // Atendimentos
  if (data.atendimentos && data.atendimentos.length > 0) {
    html += `
      <div class="section-title">
        <span class="icon">📋</span>
        <h2>Atendimentos</h2>
        <span class="count">${data.atendimentos.length}</span>
      </div>`;
    data.atendimentos.forEach((at, i) => {
      html += renderAtendimento(at, i);
    });
  }

  container.innerHTML = html;

  // Attach accordion events
  document.querySelectorAll('.atendimento-header').forEach(header => {
    header.addEventListener('click', () => {
      header.closest('.atendimento-card').classList.toggle('open');
    });
  });
}

function renderAdmin(admin) {
  return `
    <div class="section-title">
      <span class="icon">👤</span>
      <h2>Administrador</h2>
    </div>
    <div class="card admin-card">
      <div class="admin-avatar">🛡️</div>
      <div class="admin-info">
        <h3>${admin.nome}</h3>
        <div class="admin-role">Administrador do Sistema</div>
        <div class="admin-details">
          <div class="admin-detail">
            <span class="label">CPF:</span>
            <span class="value">${admin.cpf}</span>
          </div>
          <div class="admin-detail">
            <span class="label">Cadastro:</span>
            <span class="value">${formatDate(admin.dataCadastro)}</span>
          </div>
          <div class="admin-detail">
            <span class="label">Status:</span>
            <span class="badge badge-active">${admin.status}</span>
          </div>
          <div class="admin-detail" style="width: 100%; margin-top: 0.5rem; opacity: 0.8">
            <span class="label">Status Detalhado:</span>
            <span class="value" style="font-style: italic; color: var(--accent-cyan)">${admin.statusDetalhado}</span>
          </div>
        </div>
      </div>
    </div>`;
}

function renderStats(data) {
  const atds = data.atendimentos || [];
  let totalMedicos = 0, totalProcs = 0, totalExames = 0;
  atds.forEach(a => {
    totalMedicos += (a.medicos || []).length;
    totalProcs += (a.procedimentos || []).length;
    totalExames += (a.exames || []).length;
  });

  return `
    <div class="section-title" style="margin-top:2rem">
      <span class="icon">📊</span>
      <h2>Resumo Geral</h2>
    </div>
    <div class="stats-row">
      <div class="stat-card">
        <div class="stat-icon blue">🏥</div>
        <div>
          <div class="stat-number">${atds.length}</div>
          <div class="stat-label">Atendimentos</div>
        </div>
      </div>
      <div class="stat-card">
        <div class="stat-icon purple">🩺</div>
        <div>
          <div class="stat-number">${totalMedicos}</div>
          <div class="stat-label">Consultas Médicas</div>
        </div>
      </div>
      <div class="stat-card">
        <div class="stat-icon emerald">💊</div>
        <div>
          <div class="stat-number">${totalProcs}</div>
          <div class="stat-label">Procedimentos</div>
        </div>
      </div>
      <div class="stat-card">
        <div class="stat-icon amber">🔬</div>
        <div>
          <div class="stat-number">${totalExames}</div>
          <div class="stat-label">Exames</div>
        </div>
      </div>
    </div>`;
}

function renderAtendimento(at, index) {
  return `
    <div class="card atendimento-card" style="animation-delay: ${index * 0.08}s">
      <div class="atendimento-header">
        <div class="atendimento-header-left">
          <span class="atendimento-id">#${at.id}</span>
          <div class="atendimento-summary">
            <div class="atendimento-patient-name">${at.paciente.nome}</div>
            <div class="atendimento-convenio">🏢 ${at.convenio}</div>
          </div>
        </div>
        <div class="atendimento-header-right">
          <div class="atendimento-dates">
            <div class="date-label">Abertura</div>
            <div class="date-value">${formatDate(at.dataAbertura)}</div>
          </div>
          <div class="chevron">▼</div>
        </div>
      </div>
      <div class="atendimento-body">
        <div class="atendimento-content">
          ${renderObservacoes(at)}
          ${renderPaciente(at.paciente)}
          ${renderFuncionario(at.funcionario)}
          ${renderMedicos(at.medicos)}
          ${renderProcedimentos(at.procedimentos)}
          ${renderExames(at.exames)}
        </div>
      </div>
    </div>`;
}

function renderObservacoes(at) {
  return `
    <div class="detail-section">
      <div class="detail-section-title"><span class="sec-icon">📝</span> Informações Gerais</div>
      <div class="obs-grid">
        <div class="obs-item">
          <div class="obs-label">Data Abertura</div>
          <div class="obs-value">${formatDate(at.dataAbertura)}</div>
        </div>
        <div class="obs-item">
          <div class="obs-label">Data Alta</div>
          <div class="obs-value">${formatDate(at.dataAlta)}</div>
        </div>
        <div class="obs-item">
          <div class="obs-label">Observação de Entrada</div>
          <div class="obs-value">${at.observacaoEntrada}</div>
        </div>
        <div class="obs-item">
          <div class="obs-label">Observação de Alta</div>
          <div class="obs-value">${at.observacaoAlta}</div>
        </div>
      </div>
    </div>`;
}

function renderPaciente(p) {
  return `
    <div class="detail-section">
      <div class="detail-section-title"><span class="sec-icon">🧑</span> Paciente</div>
      <div class="info-row">
        <div class="info-field"><span class="field-label">Nome</span><span class="field-value">${p.nome}</span></div>
        <div class="info-field"><span class="field-label">CPF</span><span class="field-value">${p.cpf}</span></div>
        <div class="info-field"><span class="field-label">Status</span><span class="badge badge-active">${p.status}</span></div>
        <div class="info-field" style="width: 100%"><span class="field-label">Status Detalhado</span><span class="field-value" style="font-style: italic; color: var(--accent-blue-light)">${p.statusDetalhado}</span></div>
      </div>
    </div>`;
}

function renderFuncionario(f) {
  return `
    <div class="detail-section">
      <div class="detail-section-title"><span class="sec-icon">👔</span> Funcionário Responsável</div>
      <div class="info-row">
        <div class="info-field"><span class="field-label">Nome</span><span class="field-value">${f.nome}</span></div>
        <div class="info-field"><span class="field-label">CPF</span><span class="field-value">${f.cpf}</span></div>
        <div class="info-field"><span class="field-label">Setor</span><span class="field-value">${f.setor}</span></div>
        <div class="info-field" style="width: 100%"><span class="field-label">Status Detalhado</span><span class="field-value" style="font-style: italic; color: var(--accent-blue-light)">${f.statusDetalhado}</span></div>
      </div>
    </div>`;
}

function renderMedicos(medicos) {
  if (!medicos || medicos.length === 0) return '';
  let items = medicos.map(m => {
    const badgeClass = m.status === 'finalizado' ? 'badge-done' : 'badge-progress';
    return `
      <div class="sub-item">
        <div class="sub-item-header">
          <span class="sub-item-name">🩺 ${m.nomeMedico}</span>
          <span class="badge ${badgeClass}">${m.status}</span>
        </div>
        <div class="sub-item-fields">
          <div class="info-field"><span class="field-label">CRM</span><span class="field-value">${m.crm}</span></div>
          <div class="info-field"><span class="field-label">Data</span><span class="field-value">${formatDate(m.dataInicio)}</span></div>
          <div class="info-field"><span class="field-label">Observações</span><span class="field-value">${m.observacoes}</span></div>
          <div class="info-field" style="width: 100%"><span class="field-label">Status Detalhado</span><span class="field-value" style="font-style: italic; color: var(--accent-blue-light)">${m.statusDetalhado}</span></div>
        </div>
      </div>`;
  }).join('');

  return `
    <div class="detail-section">
      <div class="detail-section-title"><span class="sec-icon">🩺</span> Médicos (${medicos.length})</div>
      ${items}
    </div>`;
}

function renderProcedimentos(procs) {
  if (!procs || procs.length === 0) return '';
  let items = procs.map(p => `
    <div class="sub-item">
      <div class="sub-item-header">
        <span class="sub-item-name">💊 ${p.descricao}</span>
      </div>
      <div class="sub-item-fields">
        <div class="info-field"><span class="field-label">Data</span><span class="field-value">${formatDate(p.dataRealizada)}</span></div>
        <div class="info-field"><span class="field-label">Resultado</span><span class="field-value">${p.resultado}</span></div>
      </div>
    </div>`).join('');

  return `
    <div class="detail-section">
      <div class="detail-section-title"><span class="sec-icon">💊</span> Procedimentos (${procs.length})</div>
      ${items}
    </div>`;
}

function renderExames(exames) {
  if (!exames || exames.length === 0) return '';
  let items = exames.map(e => `
    <div class="sub-item">
      <div class="sub-item-header">
        <span class="sub-item-name">🔬 ${e.descricao} (${e.tipo})</span>
      </div>
      <div class="sub-item-fields">
        <div class="info-field"><span class="field-label">Data</span><span class="field-value">${formatDate(e.dataRealizada)}</span></div>
        <div class="info-field"><span class="field-label">Laudo</span><span class="field-value">${e.laudo}</span></div>
        <div class="info-field"><span class="field-label">Observações</span><span class="field-value">${e.observacoes}</span></div>
      </div>
    </div>`).join('');

  return `
    <div class="detail-section">
      <div class="detail-section-title"><span class="sec-icon">🔬</span> Exames (${exames.length})</div>
      ${items}
    </div>`;
}

function formatDate(dateStr) {
  if (!dateStr) return '—';
  const parts = dateStr.split('-');
  if (parts.length === 3) return `${parts[2]}/${parts[1]}/${parts[0]}`;
  return dateStr;
}